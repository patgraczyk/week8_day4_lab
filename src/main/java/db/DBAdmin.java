package db;

import models.Admin;
import models.Manager;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

public class DBAdmin {

    private static Session session;


    public static Manager getManagerOfAdmin(Admin admin){
    session = HibernateUtil.getSessionFactory().openSession();
    Manager results = null;
        try {
            Criteria cr = session.createCriteria(Manager.class);
            cr.add(Restrictions.eq("admin", admin));
            results = (Manager) cr.uniqueResult();
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            session.close();
        }

        return results;
    }

}



