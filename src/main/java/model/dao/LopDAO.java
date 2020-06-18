package model.dao;

import model.enteties.Lop;
import model.enteties.SinhVien;
import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import util.HibernateUtil;

import java.util.List;

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
}
