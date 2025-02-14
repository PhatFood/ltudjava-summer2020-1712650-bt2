package model.dao;

import model.enteties.Lop;
import model.enteties.MonHoc;
import model.enteties.SinhVien;
import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import util.HibernateUtil;

import java.util.List;

public class MonHocDAO {
    public static List<MonHoc> layDanhSachMonHoc(){
        List<MonHoc> ds = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            String hql = "select mon from MonHoc mon";
            Query query = session.createQuery(hql);
            ds = query.list();
        } catch (HibernateException ex){
            System.err.println(ex);
        } finally{
            session.close();
        }
        return ds;
    }

    public static boolean themMonHoc(MonHoc mh)
    {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.save(mh);
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

    public static MonHoc layThongTinMonHoc(String mamon)
    {
        MonHoc monHoc = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            monHoc = (MonHoc) session.get(MonHoc.class,mamon);
            /*Hibernate.initialize(monHoc.getSinhVien_monHocs());
            Hibernate.initialize(monHoc.getLop());*/
        } catch (HibernateException ex){
            System.err.println(ex);
        } finally {
            session.close();
        }
        return monHoc;
    }
}
