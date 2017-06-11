package com.calderon.sf.persistence.dao;

import com.calderon.sf.persistence.util.HibernateHelper;
import org.hibernate.Session;

/**
 * Created by Nathaniel on 6/11/2017.
 */
abstract class BasicDAO {

    public static final void saveOrUpdate(Object entity) {
        Session session = HibernateHelper.getSessionFactory().openSession();
        try {
            session.beginTransaction();
            session.saveOrUpdate(entity);
            session.getTransaction().commit();
        } catch (Exception ex) {
            session.getTransaction().rollback();
        } finally {
            session.close();
        }
    }
}
