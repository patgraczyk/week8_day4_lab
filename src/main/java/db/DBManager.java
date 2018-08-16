package db;

import models.Admin;
import models.Department;
import models.Manager;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import java.util.List;

public class DBManager {

    private static Session session;

    public static List<Admin> getAdminsForManager(Manager manager) {
        session = HibernateUtil.getSessionFactory().openSession();
        List<Admin> results = null;
        try {
            Criteria cr = session.createCriteria(Admin.class);
            cr.add(Restrictions.eq("manager", manager));
            results = cr.list();
        } catch (HibernateException ex) {
            ex.printStackTrace();
        } finally {
            session.close();
        }
        return results;
    }


    public static Department getDepartmentForManager(Manager manager) {
        session = HibernateUtil.getSessionFactory().openSession();
        Department results = null;
        try {
            Criteria cr = session.createCriteria(Department.class);
            cr.add(Restrictions.eq("manager", manager));
            results = (Department)cr.uniqueResult();
        } catch (HibernateException ex) {
            ex.printStackTrace();
        } finally {
            session.close();
        }
        return results;
    }
}