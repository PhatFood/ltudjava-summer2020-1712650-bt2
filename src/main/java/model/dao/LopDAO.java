package model.dao;

import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import model.enteties.Lop;
import model.enteties.SinhVien;
import org.hibernate.*;
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
        try{
            String hql = "SELECT lop FROM Lop lop WHERE lop.malop ='"+maLop+"'" ;
            Query query = session.createQuery(hql);
            lop = (Lop) query.uniqueResult();
            //lop = (Lop) session.get(Lop.class,maLop);
        } catch (HibernateException ex){
            System.err.println(ex);
        } finally {
            session.close();
        }
        return lop;
    }


}
