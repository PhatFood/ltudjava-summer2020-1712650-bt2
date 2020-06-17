import model.dao.BangDiemDao;
import model.dao.LopDAO;
import model.dao.MonHocDAO;
import model.dao.SinhVienDAO;
import model.enteties.BangDiem;
import model.enteties.Lop;
import model.enteties.MonHoc;
import model.enteties.SinhVien;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        SinhVien sv = new SinhVien();
        sv.setMssv("3123142");
        sv.setCmnd("4231423");
        sv.setGioiTinh("Nu");
        sv.setHoVaTen("Vo Bao Fuch");
        Lop lop = new Lop();
        lop.setMalop("17CTT9");
        sv.setLop(lop);
        boolean kq = SinhVienDAO.capNhatThongTinSinhVien(sv);
        if (kq == true)
        {
            System.out.println("OK");
        }
        else System.out.println("Not ok");

        List<SinhVien> ds= SinhVienDAO.layDanhSachSinhVien();
        for (int i = 0; i<ds.size();i++)
        {
            SinhVien sinhVien=ds.get(i);
            System.out.println("MSSV: "+sinhVien.getMssv());
            System.out.println("Ho va ten: "+sinhVien.getHoVaTen());
            System.out.println("Lop: "+sinhVien.getLop().getMalop());
            System.out.println("Cmnd: " + sinhVien.getCmnd());
        }


        /*BangDiem bd = BangDiemDao.layThongTinBangDiem("18HCB–CTT001");
        System.out.println(bd.getMaMon());*/

        /*SinhVien sv = SinhVienDAO.layThongTinSinhVien("1712699");
        if (sv!=null)
        {
            Lop lop = sv.getLop();
            System.out.println(lop.getMalop());
        }
*/
       /* SinhVien sv = SinhVienDAO.layThongTinSinhVien("1712650");
        System.out.println(sv.getHoVaTen());*/
    }
}
