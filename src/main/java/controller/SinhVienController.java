package controller;

import model.dao.SinhVienDAO;
import model.dao.TaiKhoanDAO;
import model.enteties.SinhVien;
import model.enteties.SinhVien_HocLop_Mon;
import model.enteties.TaiKhoan;
import view.SinhVienMenu;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Set;

public class SinhVienController {
    private SinhVienMenu sinhVienMenuView;
    private String mssv;

    public SinhVienController(SinhVienMenu view)
    {
        this.sinhVienMenuView = view;

        view.addXemBangDiemButtonListener(new XemBangDiemButtonListener());
        view.addDoiMatKhauButtonListener(new DoiMatKhauListener());
        view.addWindowListener(new java.awt.event.WindowAdapter (){
            @Override
            public void windowClosed(java.awt.event.WindowEvent windowEvent){
                System.exit(1);
            }
        });

        view.addDangXuatButtonListener(new DangXuatButtonListener());
    }

    public void showSinhVienMenu(String mssv)
    {
        this.mssv = mssv;
        SinhVien sv = SinhVienDAO.layThongTinSinhVien(mssv);
        Set<SinhVien_HocLop_Mon> sinhVien_hocLop_mons = sv.getSinhVien_hocLop_mons();

        sinhVienMenuView.setVisible(true);

        sinhVienMenuView.setLopMonCbb(sinhVien_hocLop_mons);

        sinhVienMenuView.setAlwaysOnTop(true);
        sinhVienMenuView.setLocationRelativeTo(null);
    }

    private class XemBangDiemButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            sinhVienMenuView.xemBangDiem();
        }
    }

    private class DoiMatKhauListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String newPass = sinhVienMenuView.layMatKhauMoi();

            TaiKhoan taiKhoan = TaiKhoanDAO.layThongTinTaiKhoan(mssv);
            if(taiKhoan!=null)
            {
                taiKhoan.setMatkhau(newPass);
                try
                {
                    TaiKhoanDAO.capNhatTaiKhoan(taiKhoan);
                }
                catch (Exception exception){
                    showMessage("Đổi mật khẩu thất bại");
                    return;
                };
                showMessage("Đổi mật khẩu thành công");

            }
            else showMessage("Đổi mật khẩu thất bại");

        }
    }

    private void showMessage(String message) {
        JOptionPane.showMessageDialog(sinhVienMenuView, message);
    }

    private class DangXuatButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            System.exit(1);
        }
    }
}
