package model.dao;

import model.enteties.BangDiem;
import model.enteties.TaiKhoan;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import util.HibernateUtil;

import java.util.List;

public class TaiKhoanDAO {

    public static boolean themTaiKhoan(TaiKhoan taiKhoan)
    {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.save(taiKhoan);
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

    public static TaiKhoan layThongTinTaiKhoan(String mataikhoan)
    {
        TaiKhoan taiKhoan = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            taiKhoan = (TaiKhoan) session.get(TaiKhoan.class,mataikhoan);
        } catch (HibernateException ex){
            System.err.println(ex);
        } finally {
            session.close();
        }
        return taiKhoan;
    }

    public static boolean capNhatTaiKhoan (TaiKhoan tk){
        boolean kq = true;
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.update(tk);
            transaction.commit();
        } catch (HibernateException ex){
            transaction.rollback();
            System.err.println(ex);
            kq=false;
        } finally {
            session.close();
        }
        return kq;
    }
}
