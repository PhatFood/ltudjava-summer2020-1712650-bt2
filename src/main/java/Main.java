import model.dao.SinhVienDAO;
import model.enteties.SinhVien;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        /*List<SinhVien> ds= SinhVienDAO.layDanhSachSinhVien();
        for (int i = 0; i<ds.size();i++)
        {
            SinhVien sv=ds.get(i);
            System.out.println("MSSV: "+sv.getMssv());
            System.out.println("Ho va ten: "+sv.getHoVaTen());
        }*/

       /* SinhVien sv = new SinhVien();
        sv.setMssv("1712650");
        sv.setCmnd("512354342");
        sv.setGioiTinh("Nu");
        sv.setHoVaTen("Vo Minh Phuc");
        sv.setLop("17CTT5");*/
        boolean kq = SinhVienDAO.xoaSinhVien("1712650");
        if (kq == true)
        {
            System.out.println("OK");
        }
        else System.out.println("Not ok");

       /* SinhVien sv = SinhVienDAO.layThongTinSinhVien("1712650");
        System.out.println(sv.getHoVaTen());*/
    }
}
