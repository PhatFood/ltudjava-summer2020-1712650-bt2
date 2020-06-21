package controller;

import model.dao.LopDAO;
import model.enteties.Lop;
import view.TKBView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class TKBController {
    private TKBView tkbView;

    public TKBController(TKBView view)
    {
        this.tkbView = view;

        view.addXemButtonListener(new XemButtonListener());
    }

    public void showTKBView()
    {
        List<Lop> lops = LopDAO.layDanhSachLop();

        tkbView.setVisible(true);
        tkbView.showCombobox(lops);
        tkbView.setAlwaysOnTop(true);
        tkbView.setLocationRelativeTo(null);
    }

    private class XemButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            tkbView.xemTKB();
        }
    }
}

