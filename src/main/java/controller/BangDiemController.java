package controller;

import model.dao.LopDAO;
import model.dao.MonHocDAO;
import model.enteties.BangDiem;
import model.enteties.Lop;
import model.enteties.MonHoc;
import view.BangDiemView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class BangDiemController {
    private BangDiemView bangDiemView;

    public BangDiemController(BangDiemView view)
    {
        this.bangDiemView = view;

        view.addXemBangDiemButtonListener(new XemBangDiemListener());
        view.addEditBangDiemButtonListener(new EditBangDiemListener());
    }

    public void showBangDiemView()
    {
        List<Lop> lopList = LopDAO.layDanhSachLop();
        List<MonHoc> monHocs = MonHocDAO.layDanhSachMonHoc();
        bangDiemView.setVisible(true);
        bangDiemView.showLopCbb(lopList);
        bangDiemView.showMonCbb(monHocs);
        bangDiemView.setAlwaysOnTop(true);
        bangDiemView.setLocationRelativeTo(null);
    }

    private class XemBangDiemListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            bangDiemView.xemBangDiem();
        }
    }

    private class EditBangDiemListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            boolean result = bangDiemView.CapNhatDiemSinhVien();
            if (result)
            {
                bangDiemView.showMessage("Cập nhật thành công");
            }
            else bangDiemView.showMessage("Cập nhật thất bại");
        }
    }
}
