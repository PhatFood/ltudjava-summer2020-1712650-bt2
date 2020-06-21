package model;

import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import model.dao.*;
import model.enteties.*;

import java.io.FileReader;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class csvReader {
    public static boolean docFileLop(String file)
    {
        try {
            // Create an object of file reader
            // class with CSV file as a parameter.
            FileReader filereader = new FileReader(file);

            // create csvReader object and skip first Line
            CSVReader csvReader = new CSVReaderBuilder(filereader)
                    .withSkipLines(0)
                    .build();
            List<String[]> allData = csvReader.readAll();

            if (allData.size()>0)
            {
                Lop lop = new Lop();
                lop.setMalop(allData.get(0)[0].replaceAll("[\uFEFF-\uFFFF]", ""));
                try{
                    LopDAO.themLop(lop);
                }   catch (Exception e){
                };

                for (int i = 2; i < allData.size(); i++)
                {
                    SinhVien sv = new SinhVien();

                    String[] row = allData.get(i);

                    sv.setMssv(row[1]);
                    sv.setHoVaTen(row[2]);
                    sv.setGioiTinh(row[3]);
                    sv.setCmnd(row[4]);
                    sv.setLop(lop);

                    TaiKhoan tk = new TaiKhoan();
                    tk.setTaikhoan(sv.getMssv());
                    tk.setMatkhau(sv.getMssv());

                    try{
                        TaiKhoanDAO.themTaiKhoan(tk);
                    }
                    catch (Exception e)
                    {

                    }

                    try{
                    SinhVienDAO.themSinhVien(sv);
                    }
                    catch (Exception e)
                    {

                    }
                }


            }
            return true;
        }
        catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static boolean docFileTKB(String file)
    {
        try {
            // Create an object of file reader
            // class with CSV file as a parameter.
            FileReader filereader = new FileReader(file);

            // create csvReader object and skip first Line
            CSVReader csvReader = new CSVReaderBuilder(filereader)
                    .withSkipLines(0)
                    .build();
            List<String[]> allData = csvReader.readAll();

            if (allData.size()>0)
            {
                Lop lop = new Lop();

                try
                { lop = LopDAO.layThongTinLop(allData.get(0)[0].replaceAll("[\uFEFF-\uFFFF]", ""));}
                catch (Exception e)
                {
                    System.err.println(e);
                    return false;
                }


                for (int i = 2; i < allData.size(); i++)
                    {
                        LopHoc_MonHoc lopHoc_monHoc;
                        lopHoc_monHoc = new LopHoc_MonHoc();

                        MonHoc monHoc = new MonHoc();

                        String[] row = allData.get(i);

                        monHoc.setMaMon(row[1]);
                        monHoc.setTenMon(row[2]);

                        lopHoc_monHoc.setLop(lop);
                        lopHoc_monHoc.setPhongHoc(row[3]);
                        lopHoc_monHoc.setMonHoc(monHoc);
                        lopHoc_monHoc.setMaLopHoc_MonHoc(lop.getMalop()+"-"+monHoc.getMaMon());


                        try{
                            MonHocDAO.themMonHoc(monHoc);
                        }
                        catch (Exception e){
                            System.err.println(e);
                        };
                        try{
                            LopHoc_MonHocDAO.themLopHoc_MonHoc(lopHoc_monHoc);
                            /*
                            lopHoc_monHoc_maSinhVien.setMonHoc(monHoc);
                            lopHoc_monHoc_maSinhVien.setMaLopHoc_MonHoc(lop.getMalop()+"-"+monHoc.getMaMon());
                            LopHoc_MonHocDAO.themLopHoc_MonHoc_MaSinhVien(lopHoc_monHoc_maSinhVien);*/
                        }
                        catch (Exception e){
                            System.err.println(e);
                        };
                }

                Set<SinhVien> sinhVienSet = new HashSet<SinhVien>();
                sinhVienSet = lop.getSinhVienSet();
                for (SinhVien sv:sinhVienSet)
                {
                    for(int i = 2; i<allData.size();i++)
                    {
                        LopHoc_MonHoc lopHoc_monHoc;
                        lopHoc_monHoc = new LopHoc_MonHoc();

                        MonHoc monHoc = new MonHoc();

                        String[] row = allData.get(i);

                        monHoc.setMaMon(row[1]);
                        monHoc.setTenMon(row[2]);

                        lopHoc_monHoc.setLop(lop);
                        lopHoc_monHoc.setPhongHoc(row[3]);
                        lopHoc_monHoc.setMonHoc(monHoc);
                        lopHoc_monHoc.setMaLopHoc_MonHoc(lop.getMalop()+"-"+monHoc.getMaMon());

                        BangDiem bangDiem = new BangDiem();
                        bangDiem.setMaBangDiem(sv.getMssv()+"-"+lopHoc_monHoc.getMaLopHoc_MonHoc());

                        SinhVien_HocLop_Mon sinhVien_hocLop_mon;
                        sinhVien_hocLop_mon = new SinhVien_HocLop_Mon();
                        sinhVien_hocLop_mon.setSinhVien(sv);
                        sinhVien_hocLop_mon.setLopHoc_monHoc(lopHoc_monHoc);
                        sinhVien_hocLop_mon.setBangDiem(bangDiem);

                        sinhVien_hocLop_mon.setMa_svhlm(sv.getMssv()+"-"+lopHoc_monHoc.getMaLopHoc_MonHoc());

                        try {
                            SinhVien_HocLop_MonDAO.themSinhVien_HocLop_Mon(sinhVien_hocLop_mon);
                        } catch (Exception e){}
                    }


                }




            }
            return true;
        }
        catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static boolean docFileDiem(String file)
    {
        try {
            // Create an object of file reader
            // class with CSV file as a parameter.
            FileReader filereader = new FileReader(file);

            // create csvReader object and skip first Line
            CSVReader csvReader = new CSVReaderBuilder(filereader)
                    .withSkipLines(0)
                    .build();
            List<String[]> allData = csvReader.readAll();

            if (allData.size()>0)
            {
                for (int i = 2; i < allData.size(); i++)
                {
                    String[] row = allData.get(i);
                   BangDiem bangDiem = new BangDiem();
                   bangDiem.setMaBangDiem(row[1]+"-"+allData.get(0)[0].replaceAll("[\uFEFF-\uFFFF]", ""));
                   bangDiem.setDiemGiuaKy(Float.parseFloat(row[3]));
                   bangDiem.setDiemCuoiKy(Float.parseFloat(row[4]));
                   bangDiem.setDiemKhac(Float.parseFloat(row[5]));
                   bangDiem.setDiemTong(Float.parseFloat(row[6]));
                    try{
                        BangDiemDAO.themBangDiem(bangDiem);
                    }
                    catch (Exception e)
                    {

                    }
                    try{
                        BangDiemDAO.capNhatThongTinBangDiem(bangDiem);
                    }
                    catch (Exception e)
                    {

                    }
                }
            }
            return true;
        }
        catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
