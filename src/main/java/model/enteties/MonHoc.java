package model.enteties;

import java.util.HashSet;
import java.util.Set;

public class MonHoc implements java.io.Serializable {
    public String getMaMon() {
        return maMon;
    }

    public void setMaMon(String maMon) {
        this.maMon = maMon;
    }

    public String getTenMon() {
        return tenMon;
    }

    public void setTenMon(String tenMon) {
        this.tenMon = tenMon;
    }

    public String getPhongHoc() {
        return phongHoc;
    }

    public void setPhongHoc(String phongHoc) {
        this.phongHoc = phongHoc;
    }

    public String getLop() {
        return lop;
    }

    public void setLop(String lop) {
        this.lop = lop;
    }

    private String maMon;
    private String tenMon;
    private String phongHoc;
    private String lop;

    public Set<SinhVien_MonHoc> getSinhVien_monHocs() {
        return sinhVien_monHocs;
    }

    public void setSinhVien_monHocs(Set<SinhVien_MonHoc> sinhVien_monHocs) {
        this.sinhVien_monHocs = sinhVien_monHocs;
    }

    private Set<SinhVien_MonHoc> sinhVien_monHocs = new HashSet<SinhVien_MonHoc>(0);
}
