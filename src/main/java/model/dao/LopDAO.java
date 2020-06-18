package model.dao;

import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import model.enteties.Lop;
import model.enteties.SinhVien;
import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import util.HibernateUtil;

import java.io.FileReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LopDAO {
    public static List<Lop> layDanhSachLop(){
        List<Lop> ds = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            String hql = "select lop from Lop lop";
            Query query = session.createQuery(hql);
            ds = query.list();
        } catch (HibernateException ex){
            System.err.println(ex);
        } finally{
            session.close();
        }
        return ds;
    }

    public static boolean themLop(Lop lop)
    {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.save(lop);
            transaction.commit();
        }
        catch (HibernateException ex)
        {
            transaction.rollback();
            System.err.println(ex);
        } finally {
            session.close();
        }
        return true;
    }

    public static Lop layThongTinLop(String maLop)
    {
        Lop lop = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            lop = (Lop) session.get(Lop.class,maLop);
            Hibernate.initialize(lop.getSinhVienSet());
        } catch (HibernateException ex){
            System.err.println(ex);
        } finally {
            session.close();
        }
        return lop;
    }

   /* public static boolean docFileCsv(String file)
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

                    SinhVienDAO.themSinhVien(sv);
                }


            }
            return true;
        }
        catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }*/
}
