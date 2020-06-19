package model.dao;

import model.enteties.LopHoc_MonHoc;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import util.HibernateUtil;

import java.util.List;

public class LopHoc_MonHocDAO {
    public static List<LopHoc_MonHoc> layDanhSachLopHoc_MonHoc(){
        List<LopHoc_MonHoc> ds = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            String hql = "select lhmhsv from LopHoc_MonHoc lhmhsv";
            Query query = session.createQuery(hql);
            ds = query.list();
        } catch (HibernateException ex){
            System.err.println(ex);
        } finally{
            session.close();
        }
        return ds;
    }

    public static boolean themLopHoc_MonHoc(LopHoc_MonHoc lopHoc_monHoc)
    {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.save(lopHoc_monHoc);
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

    public static LopHoc_MonHoc layThongTinLopHoc_MonHoc(String maLopHoc_MonHoc)
    {
        LopHoc_MonHoc lopHoc_monHoc = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            lopHoc_monHoc = (LopHoc_MonHoc) session.get(LopHoc_MonHoc.class,maLopHoc_MonHoc);
            /*Hibernate.initialize(sv.getLop());
            Hibernate.initialize(sv.getSinhVien_monHocs());*/
        } catch (HibernateException ex){
            System.err.println(ex);
        } finally {
            session.close();
        }
        return lopHoc_monHoc;
    }
}
