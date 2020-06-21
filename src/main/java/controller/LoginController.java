package controller;

import model.dao.TaiKhoanDAO;
import model.enteties.TaiKhoan;
import view.Login;
import view.GiaoVuMenu;
import view.SinhVienMenu;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginController {
    private Login loginView;

    public LoginController(Login view)
    {
        this.loginView =view;

        loginView.addLoginButtonListener(new LoginListener());

        loginView.addWindowListener(new java.awt.event.WindowAdapter (){
            @Override
            public void windowClosed(java.awt.event.WindowEvent windowEvent){
                System.exit(1);
            }
        });

    }

    public void showLoginView()
    {
        loginView.setVisible(true);
        loginView.setLocationRelativeTo(null);
    }

    private class LoginListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            TaiKhoan tk = loginView.getTaiKhoan();
            if (tk.getTaikhoan().equals("giaovu"))
            {
                TaiKhoan giaoVu = TaiKhoanDAO.layThongTinTaiKhoan("giaovu");
                if (giaoVu == null)
                {
                    giaoVu = new TaiKhoan();
                    giaoVu.setTaikhoan("giaovu");
                    giaoVu.setMatkhau("giaovu");
                    TaiKhoanDAO.themTaiKhoan(giaoVu);
                }
                if(tk.getMatkhau().equals(giaoVu.getMatkhau()))
                {
                    GiaoVuMenu view = new GiaoVuMenu();
                    GiaoVuMenuController a = new GiaoVuMenuController(view);
                    a.showMenuGiaoVu();
                    loginView.setVisible(false);
                }
                else{
                    showMessage("Đăng nhập thất bại");
                }
            }
            else if(TaiKhoanDAO.layThongTinTaiKhoan(tk.getTaikhoan())!= null)
            {
                TaiKhoan taiKhoanData = TaiKhoanDAO.layThongTinTaiKhoan(tk.getTaikhoan());
                if(tk.getMatkhau().equals(taiKhoanData.getMatkhau()))
                {
                    SinhVienMenu view = new SinhVienMenu();
                    SinhVienController a = new SinhVienController(view);
                    a.showSinhVienMenu(taiKhoanData.getTaikhoan());
                    loginView.setVisible(false);
                }
                else{
                    showMessage("Đăng nhập thất bại");
                }
            }
        }
    }

    private void showMessage(String message) {
        JOptionPane.showMessageDialog(loginView, message);
    }
}
