package model.dao;

import model.enteties.SinhVien;
import model.enteties.SinhVien_HocLop_Mon;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import util.HibernateUtil;

import java.util.List;

public class SinhVien_HocLop_MonDAO {
    public static List<SinhVien_HocLop_Mon> layDanhSachSinhVien_HocLop_Mon(){
        List<SinhVien_HocLop_Mon> ds = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            String hql = "select svhlm from SinhVien_HocLop_Mon svhlm";
            Query query = session.createQuery(hql);
            ds = query.list();
        } catch (HibernateException ex){
            System.err.println(ex);
        } finally{
            session.close();
        }
        return ds;
    }

    public static boolean xoaSinhVien_HocLop_Mon(SinhVien_HocLop_Mon sinhVien_hocLop_mon)
    {
        boolean result = false;
        Session session = HibernateUtil.getSessionFactory().openSession();
        if (sinhVien_hocLop_mon == null)
            return false;
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.delete(sinhVien_hocLop_mon);
            transaction.commit();
        } catch (HibernateException ex){
            transaction.rollback();
            System.err.println(ex);
            result = false;
        } finally {
            session.close();
            return result;
        }
    }

    public static SinhVien_HocLop_Mon layThongTinSinhVien_HocLop_Mon(String ma_svhlm)
    {
        SinhVien_HocLop_Mon sinhVien_hocLop_mon = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            sinhVien_hocLop_mon = (SinhVien_HocLop_Mon) session.get(SinhVien_HocLop_Mon.class,ma_svhlm);
        } catch (HibernateException ex){
            System.err.println(ex);
        } finally {
            session.close();
        }
        return sinhVien_hocLop_mon;
    }

    public static boolean themSinhVien_HocLop_Mon(SinhVien_HocLop_Mon sinhVien_hocLop_mon)
    {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.save(sinhVien_hocLop_mon);
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
}
