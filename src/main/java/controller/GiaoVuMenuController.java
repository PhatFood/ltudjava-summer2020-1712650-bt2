package controller;

import view.GiaoVuMenu;
import view.Login;
import view.LopView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GiaoVuMenuController {
    private GiaoVuMenu menuGiaoVu;
    public GiaoVuMenuController(GiaoVuMenu view)
    {
        this.menuGiaoVu = view;

        view.addXemLopButtonListenner(new XemLopListener());
        view.addDangXuatButtonListenner(new DangXuatListenner());

    }

    public void showMenuGiaoVu()
    {
        menuGiaoVu.setVisible(true);
    }

    private class XemLopListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            LopView view = new LopView();
            LopController a = new LopController(view);
            a.showLopView();
        }
    }

    private class DangXuatListenner implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            Login view = new Login();
            LoginController a = new LoginController(view);
            a.showLoginView();
            menuGiaoVu.dispose();
        }
    }
}
