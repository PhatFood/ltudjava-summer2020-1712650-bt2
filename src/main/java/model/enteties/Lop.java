package model.enteties;

import java.util.HashSet;
import java.util.Set;

public class Lop implements java.io.Serializable{

    public String getMalop() {
        return malop;
    }

    public void setMalop(String malop) {
        this.malop = malop;
    }

    private String malop;

    public Set<SinhVien> getSinhVienSet() {
        return sinhVienSet;
    }

    public void setSinhVienSet(Set<SinhVien> sinhVienSet) {
        this.sinhVienSet = sinhVienSet;
    }

    public Set<LopHoc_MonHoc> getLopHoc_monHocs() {
        return lopHoc_monHocs;
    }

    public void setLopHoc_monHocs(Set<LopHoc_MonHoc> lopHoc_monHocs) {
        this.lopHoc_monHocs = lopHoc_monHocs;
    }

    private Set<LopHoc_MonHoc> lopHoc_monHocs = new HashSet<LopHoc_MonHoc>(0);

    private Set<SinhVien> sinhVienSet = new HashSet<SinhVien>(0);
}
