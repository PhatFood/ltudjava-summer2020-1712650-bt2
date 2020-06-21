package controller;

import model.dao.*;
import model.enteties.*;
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
        view.addThemSinhVienLopMonListener(new ThemSinhVienLopMonListener());
    }

    public void showLopView()
    {
        List<Lop> lopList = LopDAO.layDanhSachLop();
        List<MonHoc> monHocList = MonHocDAO.layDanhSachMonHoc();
        lopView.setVisible(true);
        lopView.showMonHoc(monHocList);
        lopView.showListLop(lopList);
        lopView.setAlwaysOnTop(true);
        lopView.setLocationRelativeTo(null);
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

                TaiKhoan tk = new TaiKhoan();
                tk.setTaikhoan(sinhVien.getMssv());
                tk.setMatkhau(sinhVien.getMssv());

                try{
                    TaiKhoanDAO.themTaiKhoan(tk);
                }
                catch (Exception exception)
                {

                }
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
            MonHoc mh = lopView.layThongTinMonHoc();
            if(mh==null) {
                if (sv != null) {
                    Set<SinhVien_HocLop_Mon> sinhVien_hocLop_mons = sv.getSinhVien_hocLop_mons();
                    for (SinhVien_HocLop_Mon sinhVien_hocLop_mon : sinhVien_hocLop_mons) {
                        SinhVien_HocLop_MonDAO.xoaSinhVien_HocLop_Mon(sinhVien_hocLop_mon);
                    }

                    try {
                        SinhVienDAO.xoaSinhVien(sv);
                    } catch (Exception ex) {
                        lopView.showMessage("Xóa sinh viên thất bại!");
                    }
                    ;
                    lopView.updateDataLop(LopDAO.layDanhSachLop());
                    lopView.xemLop();
                    lopView.showMessage("Xóa sinh viên thành công!");
                } else lopView.showMessage("Xóa sinh viên thất bại!");
            }
            else {
                if (sv != null) {
                    Set<SinhVien_HocLop_Mon> sinhVien_hocLop_mons = sv.getSinhVien_hocLop_mons();
                    for (SinhVien_HocLop_Mon sinhVien_hocLop_mon : sinhVien_hocLop_mons) {
                        if (sinhVien_hocLop_mon.getLopHoc_monHoc().getMonHoc().getMaMon().equals(mh.getMaMon())) {
                            SinhVien_HocLop_MonDAO.xoaSinhVien_HocLop_Mon(sinhVien_hocLop_mon);
                            lopView.showMessage("Xóa sinh viên thành công!");
                            lopView.updateDataLop(LopDAO.layDanhSachLop());
                            lopView.xemLop();
                            return;
                        }
                    }
                    lopView.showMessage("Xóa sinh viên thất bại!");
                } else lopView.showMessage("Xóa sinh viên thất bại!");
            }
        }
    }

    private class ThemSinhVienLopMonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String mssv = lopView.layMSSVQuaDialog();
            LopHoc_MonHoc lopHoc_monHoc = lopView.layLopHocMonHOc();

            SinhVien sv = SinhVienDAO.layThongTinSinhVien(mssv);
            if (sv != null && lopHoc_monHoc != null)
            {
                SinhVien_HocLop_Mon sinhVien_hocLop_mon = new SinhVien_HocLop_Mon();
                BangDiem bangDiem = new BangDiem();
                bangDiem.setMaBangDiem(sv.getMssv()+"-"+lopHoc_monHoc.getMaLopHoc_MonHoc());

                sinhVien_hocLop_mon.setSinhVien(sv);
                sinhVien_hocLop_mon.setLopHoc_monHoc(lopHoc_monHoc);
                sinhVien_hocLop_mon.setBangDiem(bangDiem);

                sinhVien_hocLop_mon.setMa_svhlm(sv.getMssv()+"-"+lopHoc_monHoc.getMaLopHoc_MonHoc());
                try {
                    SinhVien_HocLop_MonDAO.themSinhVien_HocLop_Mon(sinhVien_hocLop_mon);
                } catch (Exception exception){
                    lopView.showMessage("Thêm sinh viên thất bại!");
                    return;
                }
                lopView.showListLop(LopDAO.layDanhSachLop());
                lopView.xemLop();
                lopView.showMessage("Thêm sinh viên thành công!");
            }
            else
                lopView.showMessage("Thêm sinh viên thất bại!");
            /*if (sinhVien != null)
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
                lopView.showMessage("Thêm sinh viên thất bại!");*/
        }
    }
}
