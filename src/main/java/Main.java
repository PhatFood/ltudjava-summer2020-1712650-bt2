import model.csvReader;

public class Main {

    public static void main(String[] args) {

        String file = "E:/Code/Nam3_2019/Ky2/LapTrinhJava/DeadLine/InputHibernate/17HCB.csv";
        boolean check = csvReader.docFileLop(file);
        if (check)
        {
            System.out.println("OK");
        }

       /* SinhVien sv = new SinhVien();
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
        else System.out.println("Not ok");

        List<SinhVien> ds= SinhVienDAO.layDanhSachSinhVien();
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
