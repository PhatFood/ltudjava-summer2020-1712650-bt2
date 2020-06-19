package model.enteties;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class LopHoc_MonHoc implements Serializable {

    public Set<SinhVien_HocLop_Mon> getSinhVien_hocLop_mons() {
        return sinhVien_hocLop_mons;
    }

    public void setSinhVien_hocLop_mons(Set<SinhVien_HocLop_Mon> sinhVien_hocLop_mons) {
        this.sinhVien_hocLop_mons = sinhVien_hocLop_mons;
    }

    private Set<SinhVien_HocLop_Mon> sinhVien_hocLop_mons = new HashSet<SinhVien_HocLop_Mon>(0);

    public MonHoc getMonHoc() {
        return monHoc;
    }

    public void setMonHoc(MonHoc monHoc) {
        this.monHoc = monHoc;
    }

    public Lop getLop() {
        return lop;
    }

    public void setLop(Lop lop) {
        this.lop = lop;
    }

    private MonHoc monHoc;

    public String getMaLopHoc_MonHoc() {
        return maLopHoc_MonHoc;
    }

    public void setMaLopHoc_MonHoc(String maLopHoc_MonHoc) {
        this.maLopHoc_MonHoc = maLopHoc_MonHoc;
    }

    private String maLopHoc_MonHoc;
    private Lop lop;

    public String getPhongHoc() {
        return phongHoc;
    }

    public void setPhongHoc(String phongHoc) {
        this.phongHoc = phongHoc;
    }

    private String phongHoc;



}
