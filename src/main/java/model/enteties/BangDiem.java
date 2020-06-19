package model.enteties;

import java.io.Serializable;

public class BangDiem  implements Serializable {
    public String getMaBangDiem() {
        return maBangDiem;
    }

    public void setMaBangDiem(String maBangDiem) {
        this.maBangDiem = maBangDiem;
    }

    public float getDiemGiuaKy() {
        return diemGiuaKy;
    }

    public void setDiemGiuaKy(float diemGiuaKy) {
        this.diemGiuaKy = diemGiuaKy;
    }

    public float getDiemCuoiKy() {
        return diemCuoiKy;
    }

    public void setDiemCuoiKy(float diemCuoiKy) {
        this.diemCuoiKy = diemCuoiKy;
    }

    public float getDiemKhac() {
        return diemKhac;
    }

    public void setDiemKhac(float diemKhac) {
        this.diemKhac = diemKhac;
    }

    public float getDiemTong() {
        return diemTong;
    }

    public void setDiemTong(float diemTong) {
        this.diemTong = diemTong;
    }

    /*public SinhVien_HocLop_Mon getSinhVien_hocLop_mon() {
        return sinhVien_hocLop_mon;
    }

    public void setSinhVien_hocLop_mon(SinhVien_HocLop_Mon sinhVien_hocLop_mon) {
        this.sinhVien_hocLop_mon = sinhVien_hocLop_mon;
    }

    private SinhVien_HocLop_Mon sinhVien_hocLop_mon;*/
    private String maBangDiem;
    private float diemGiuaKy;
    private float diemCuoiKy;
    private float diemKhac;
    private float diemTong;
}
