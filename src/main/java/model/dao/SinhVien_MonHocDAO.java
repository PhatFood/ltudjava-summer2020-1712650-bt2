package model.dao;

import model.enteties.SinhVien;
import model.enteties.SinhVien_MonHoc;
import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;
import util.HibernateUtil;

import java.util.List;

public class SinhVien_MonHocDAO {
    public static List<SinhVien_MonHoc> layDanhSachSinhVien_MonHoc(){
        List<SinhVien_MonHoc> ds = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            String hql = "select svmh from SinhVien_MonHoc svmh";
            Query query = session.createQuery(hql);
            ds = query.list();
        } catch (HibernateException ex){
            System.err.println(ex);
        } finally{
            session.close();
        }
        return ds;
    }
}
