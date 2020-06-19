package model.enteties;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class SinhVien_HocLop_Mon implements Serializable {
    private BangDiem bangDiem;
    private String ma_svhlm;
    private SinhVien sinhVien = new SinhVien();
    private LopHoc_MonHoc lopHoc_monHoc = new LopHoc_MonHoc();

    public BangDiem getBangDiem() {
        return bangDiem;
    }

    public void setBangDiem(BangDiem bangDiem) {
        this.bangDiem = bangDiem;
    }

    public String getMa_svhlm() {
        return ma_svhlm;
    }

    public void setMa_svhlm(String ma_svhlm) {
        this.ma_svhlm = ma_svhlm;
    }

    public SinhVien getSinhVien() {
        return sinhVien;
    }

    public void setSinhVien(SinhVien sinhVien) {
        this.sinhVien = sinhVien;
    }

    public LopHoc_MonHoc getLopHoc_monHoc() {
        return lopHoc_monHoc;
    }

    public void setLopHoc_monHoc(LopHoc_MonHoc lopHoc_monHoc) {
        this.lopHoc_monHoc = lopHoc_monHoc;
    }
}
