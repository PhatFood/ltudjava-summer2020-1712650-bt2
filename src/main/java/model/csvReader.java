package model;

import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import model.dao.SinhVienDAO;
import model.enteties.Lop;
import model.enteties.SinhVien;

import java.io.FileReader;
import java.util.List;

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
                lop.setMalop(allData.get(0)[0]);


                for (int i = 2; i < allData.size(); i++)
                {
                    SinhVien sv = new SinhVien();
                    //sv.setLop(lop);

                    String[] row = allData.get(i);

                    sv.setMssv(row[1]);
                    sv.setHoVaTen(row[2]);
                    sv.setGioiTinh(row[3]);
                    sv.setCmnd(row[4]);
                    sv.setLop(lop);

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
}
