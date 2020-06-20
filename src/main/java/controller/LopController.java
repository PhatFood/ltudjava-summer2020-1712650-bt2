package controller;

import model.dao.LopDAO;
import model.dao.MonHocDAO;
import model.dao.SinhVienDAO;
import model.dao.SinhVien_HocLop_MonDAO;
import model.enteties.Lop;
import model.enteties.MonHoc;
import model.enteties.SinhVien;
import model.enteties.SinhVien_HocLop_Mon;
import view.LopView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Set;

public class LopController {
    private LopView lopView;

    public LopController(LopView view)
    {
        this.lopView =view;

        view.addThemSinhVienButtonListener(new ThemSinhVienListener());
        view.addXemButtonListener(new XemLopListener());
        view.addXoaSinhVienButtonListener(new XoaSinhVienListener());
    }

    public void showLopView()
    {
        List<Lop> lopList = LopDAO.layDanhSachLop();
        List<MonHoc> monHocList = MonHocDAO.layDanhSachMonHoc();
        lopView.setVisible(true);
        lopView.showMonHoc(monHocList);
        lopView.showListLop(lopList);

    }

    private class ThemSinhVienListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e){
            SinhVien sinhVien = lopView.laySinhVienInfoQuaDialog();
            if (sinhVien != null)
            {
                try{
                    LopDAO.themLop(sinhVien.getLop());
                } catch (Exception ex){};
                SinhVienDAO.themSinhVien(sinhVien);
                lopView.showListLop(LopDAO.layDanhSachLop());
                lopView.xemLop();
                lopView.showMessage("Thêm sinh viên thành công!");
            }
            else
                lopView.showMessage("Thêm sinh viên thất bại!");
        }
    }

    private class XemLopListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            lopView.xemLop();
        }
    }

    private class XoaSinhVienListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            SinhVien sv = lopView.layThongTinSinhVienQuaTable();
            if (sv != null)
            {
                Set<SinhVien_HocLop_Mon> sinhVien_hocLop_mons = sv.getSinhVien_hocLop_mons();
                for (SinhVien_HocLop_Mon sinhVien_hocLop_mon:sinhVien_hocLop_mons)
                {
                    SinhVien_HocLop_MonDAO.xoaSinhVien_HocLop_Mon(sinhVien_hocLop_mon);
                }

                try{
                    SinhVienDAO.xoaSinhVien(sv);
                } catch (Exception ex){
                    lopView.showMessage("Xóa sinh viên thất bại!");
                };
                lopView.updateDataLop(LopDAO.layDanhSachLop());
                lopView.xemLop();
                lopView.showMessage("Xóa sinh viên thành công!");
            }
            else lopView.showMessage("Xóa sinh viên thất bại!");

        }
    }
}
