package model.dao;

import org.hibernate.*;
import util.HibernateUtil;
import model.enteties.SinhVien;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.List;

public class SinhVienDAO {

    public static List<SinhVien> layDanhSachSinhVien(){
        List<SinhVien> ds = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            String hql = "select sv from SinhVien sv";
            Query query = session.createQuery(hql);
            ds = query.list();
        } catch (HibernateException ex){
            System.err.println(ex);
        } finally{
            session.close();
        }
        return ds;
    }

    public static SinhVien layThongTinSinhVien(String mssv)
    {
        SinhVien sv = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            sv = (SinhVien) session.get(SinhVien.class,mssv);
            /*Hibernate.initialize(sv.getLop());
            Hibernate.initialize(sv.getSinhVien_monHocs());*/
        } catch (HibernateException ex){
            System.err.println(ex);
        } finally {
            session.close();
        }
        return sv;
    }

    public static SinhVien layThongTinSinhVienQuaCmnd(String cmnd)
    {
        SinhVien sv = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            String hql = "SELECT sv FROM SinhVien sv WHERE sv.cmnd ='"+cmnd+"'" ;
            Query query = session.createQuery(hql);
            sv = (SinhVien) query.uniqueResult();
        } catch (HibernateException ex){
            System.err.println(ex);
            sv = null;
        } finally {
            session.close();
        }
        return sv;
    }

    public static boolean themSinhVien(SinhVien sv)
    {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.save(sv);
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

    public static boolean xoaSinhVien(String maSinhVien)
    {
        boolean result = false;
        Session session = HibernateUtil.getSessionFactory().openSession();
        SinhVien sv = SinhVienDAO.layThongTinSinhVien(maSinhVien);
        if (sv == null)
            return false;
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.delete(sv);
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

    public static boolean xoaSinhVien(SinhVien sv)
    {
        boolean result = false;
        Session session = HibernateUtil.getSessionFactory().openSession();
        if (sv == null)
            return false;
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.delete(sv);
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

    public static boolean capNhatThongTinSinhVien (SinhVien sv){
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.update(sv);
            transaction.commit();
        } catch (HibernateException ex){
            transaction.rollback();
            System.err.println(ex);
        } finally {
            session.close();
        }
        return true;
    }
}
