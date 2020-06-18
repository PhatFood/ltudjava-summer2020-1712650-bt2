package model.enteties;

import java.util.HashSet;
import java.util.Set;

public class SinhVien implements java.io.Serializable{
    private String mssv;
    private String hoVaTen;
    private String gioiTinh;
    private String cmnd;
    private Lop lop;

    public Set<SinhVien_MonHoc> getSinhVien_monHocs() {
        return sinhVien_monHocs;
    }

    public void setSinhVien_monHocs(Set<SinhVien_MonHoc> sinhVien_monHocs) {
        this.sinhVien_monHocs = sinhVien_monHocs;
    }

    private Set<SinhVien_MonHoc> sinhVien_monHocs = new HashSet<SinhVien_MonHoc>(0);

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
