package model.dao;

import model.enteties.BangDiem;
import model.enteties.MonHoc;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;
import util.HibernateUtil;

import java.util.List;

public class BangDiemDao {
    public static List<BangDiem> layDanhSachBangDiem(){
        List<BangDiem> ds = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            String hql = "select bangdiem from BangDiem bangdiem";
            Query query = session.createQuery(hql);
            ds = query.list();
        } catch (HibernateException ex){
            System.err.println(ex);
        } finally{
            session.close();
        }
        return ds;
    }

    public static BangDiem layThongTinBangDiem(String mabangdiem)
    {
        BangDiem bangDiem = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            bangDiem = (BangDiem) session.get(BangDiem.class,mabangdiem);
        } catch (HibernateException ex){
            System.err.println(ex);
        } finally {
            session.close();
        }
        return bangDiem;
    }
}
