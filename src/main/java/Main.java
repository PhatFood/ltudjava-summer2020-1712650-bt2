import model.csvReader;
import model.dao.LopDAO;
import model.dao.MonHocDAO;
import model.dao.SinhVienDAO;
import model.enteties.Lop;
import model.enteties.MonHoc;
import model.enteties.SinhVien;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class Main {

    public static void main(String[] args) {


        /*List<Lop> ds1 = LopDAO.layDanhSachLop();
        System.out.println(""+ds1.size());
        for (int i = 0; i<ds1.size() ; i++)
        {
            Lop lop = ds1.get(i);
            System.out.println(lop.getMalop());
            Set<MonHoc> monHocs=new HashSet<>();
            monHocs = lop.getMonHocSet();
            for(MonHoc test : monHocs)
            {
                System.out.println(test.getTenMon());
            }
        }*/

       /* Lop lopTest = new Lop();
        lopTest.setMalop("17CTTest");
        try{
            LopDAO.themLop(lopTest);
        } catch (Exception e){};*/

       /* Lop lop = LopDAO.layThongTinLop("17CTT9");

        Set<SinhVien> sinhViens = new HashSet<>();
        sinhViens = lop.getSinhVienSet();
        for(SinhVien test : sinhViens)
        {
            System.out.println(test.getHoVaTen());
        }*/

        /*SinhVien a = SinhVienDAO.layThongTinSinhVien("1742005");

        Set<SinhVien_MonHoc> sinhVien_monHocs = new HashSet<SinhVien_MonHoc>();
        sinhVien_monHocs = a.getSinhVien_monHocs();
        System.out.println(sinhVien_monHocs.isEmpty());*/

        /*Iterator<SinhVien_MonHoc> sinhVien_monHocIterator = sinhVien.getSinhVien_monHocs().iterator();
        while(sinhVien_monHocIterator.hasNext())
        {
            SinhVien_MonHoc sinhVien_monHoc=sinhVien_monHocIterator.next();
            System.out.println(sinhVien_monHoc.getMsSv_Mh());
        }*/

        /*try{
        Lop lop = LopDAO.layThongTinLop("17HCB");
        Iterator<SinhVien> sinhVienIterator = lop.getSinhVienSet().iterator();
        while(sinhVienIterator.hasNext())
        {
            SinhVien sinhVien=sinhVienIterator.next();
            System.out.println(sinhVien.getHoVaTen());
        }
        } catch (Exception e)
        {}*/

        String file = "E:/Code/Nam3_2019/Ky2/LapTrinhJava/DeadLine/InputHibernate/bangdiem.csv";
        boolean check = csvReader.docFileDiem(file);
        if (check)
        {
            System.out.println("OK");
        }

        /*SinhVien sv = new SinhVien();
        sv.setMssv("3123142");
        sv.setCmnd("4231423");
        sv.setGioiTinh("Nu");
        sv.setHoVaTen("Vo Bao Fuch");
        Lop lop = new Lop();
        lop.setMalop("17CTT9");
        sv.setLop(lop);
        boolean kq = SinhVienDAO.themSinhVien(sv);
        if (kq == true)
        {
            System.out.println("OK");
        }
        else System.out.println("Not ok");*/

        /*SinhVien a = SinhVienDAO.layThongTinSinhVien("1742005");

        Set<SinhVien_MonHoc> sinhVien_monHocs = new HashSet<SinhVien_MonHoc>();
        sinhVien_monHocs = a.getSinhVien_monHocs();
        System.out.println(sinhVien_monHocs.isEmpty());*/

        /*List<SinhVien> ds= SinhVienDAO.layDanhSachSinhVien();
        for (int i = 0; i<ds.size();i++)
        {
            SinhVien sinhVien=ds.get(i);
            System.out.println("MSSV: "+sinhVien.getMssv());
            System.out.println("Ho va ten: "+sinhVien.getHoVaTen());
            System.out.println("Lop: "+sinhVien.getLop().getMalop());
            System.out.println("Cmnd: " + sinhVien.getCmnd());
            System.out.println("Hoc: " + sinhVien.getSinhVien_monHocs().isEmpty());
        }*/

        /*List<MonHoc> ds1 = MonHocDAO.layDanhSachMonHoc();
        System.out.println(""+ds1.size());
        for (int i = 0; i<ds1.size() ; i++)
        {
            MonHoc monHoc = ds1.get(i);
            System.out.println(monHoc.getTenMon());
            Iterator<SinhVien_MonHoc> sinhViens = monHoc.getSinhVien_monHocs().iterator();
            while(sinhViens.hasNext()){
                SinhVien_MonHoc s = sinhViens.next();
                System.out.println(s.getSinhVien().getHoVaTen());
            }
        }*/


        /*BangDiem bd = BangDiemDao.layThongTinBangDiem("18HCB–CTT001");
        System.out.println(bd.getMaMon());*/

        /*SinhVien sv = SinhVienDAO.layThongTinSinhVien("1712699");
        if (sv!=null)
        {
            Lop lop = sv.getLop();
            System.out.println(lop.getMalop());
        }*/

       /* SinhVien sv = SinhVienDAO.layThongTinSinhVien("1712650");
        System.out.println(sv.getHoVaTen());*/
    }
}
