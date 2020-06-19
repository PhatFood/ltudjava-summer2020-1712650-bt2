package model.enteties;

import java.util.HashSet;
import java.util.Set;

public class SinhVien implements java.io.Serializable{
    private String mssv;
    private String hoVaTen;
    private String gioiTinh;
    private String cmnd;
    private Lop lop;

    public Set<SinhVien_HocLop_Mon> getSinhVien_hocLop_mons() {
        return sinhVien_hocLop_mons;
    }

    public void setSinhVien_hocLop_mons(Set<SinhVien_HocLop_Mon> sinhVien_hocLop_mons) {
        this.sinhVien_hocLop_mons = sinhVien_hocLop_mons;
    }

    private Set<SinhVien_HocLop_Mon> sinhVien_hocLop_mons = new HashSet<SinhVien_HocLop_Mon>(0);

    public String getMssv() {
        return mssv;
    }

    public void setMssv(String mssv) {
        this.mssv = mssv;
    }

    public String getHoVaTen() {
        return hoVaTen;
    }

    public void setHoVaTen(String hoVaTen) {
        this.hoVaTen = hoVaTen;
    }

    public String getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(String gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public String getCmnd() {
        return cmnd;
    }

    public void setCmnd(String cmnd) {
        this.cmnd = cmnd;
    }

    public Lop getLop() {
        return lop;
    }

    public void setLop(Lop lop) {
        this.lop = lop;
    }
}
