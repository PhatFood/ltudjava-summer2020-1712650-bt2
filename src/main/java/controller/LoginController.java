package controller;

import view.Login;
import view.GiaoVuMenu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginController {
    private Login loginView;

    public LoginController(Login view)
    {
        this.loginView =view;

        loginView.addLoginButtonListener(new LoginListener());
    }

    public void showLoginView()
    {
        loginView.setVisible(true);
    }

    private class LoginListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            GiaoVuMenu view = new GiaoVuMenu();
            GiaoVuMenuController a = new GiaoVuMenuController(view);
            a.showMenuGiaoVu();
            loginView.dispose();
        }
    }
}
