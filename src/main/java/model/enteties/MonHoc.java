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


    private String maMon;
    private String tenMon;

    public Set<LopHoc_MonHoc> getLopHoc_monHocs() {
        return lopHoc_monHocs;
    }

    public void setLopHoc_monHocs(Set<LopHoc_MonHoc> lopHoc_monHocs) {
        this.lopHoc_monHocs = lopHoc_monHocs;
    }

    private Set<LopHoc_MonHoc> lopHoc_monHocs = new HashSet<LopHoc_MonHoc>(0);
}
