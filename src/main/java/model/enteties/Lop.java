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

    private Set<SinhVien> sinhVienSet = new HashSet<SinhVien>(0);
}
