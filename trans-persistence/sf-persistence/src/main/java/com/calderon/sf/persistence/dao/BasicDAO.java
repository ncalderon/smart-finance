package com.calderon.sf.persistence.dao;

import com.calderon.sf.persistence.util.HibernateHelper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Hibernate;
import org.hibernate.Session;

import java.util.function.Supplier;

/**
 * Created by Nathaniel on 6/11/2017.
 */
abstract class BasicDAO {

    private static final Logger log = LogManager.getLogger(BasicDAO.class.getName());

    public static final void saveOrUpdate(Object entity) {
        log.info("Trying to saveOrUpdate Entity: " + entity);
        Session session = HibernateHelper.getSessionFactory().openSession();
        try {
            session.beginTransaction();
            session.saveOrUpdate(entity);
            session.getTransaction().commit();
        } catch (Exception ex) {
            session.getTransaction().rollback();
            log.info("Error trying to saveOrUpdate an Entity... ", ex);
            ex.printStackTrace();
        } finally {
            if (session.isOpen())
                session.close();

        }
    }

    public static final void delete (Object entity) {
        log.info("Trying to delete Entity: " + entity);
        Session session = HibernateHelper.getSessionFactory().openSession();
        try {
            session.beginTransaction();
            session.delete(entity);
            session.getTransaction().commit();
        } catch (Exception ex) {
            session.getTransaction().rollback();
            log.info("Error trying to delete an Entity... ", ex);
            ex.printStackTrace();
        } finally {
            if (session.isOpen())
                session.close();
        }
    }

    public static final void initialize(Supplier<Object> supplier) {
        log.info("Initializing ProxyInstance... " + supplier);
        Session session = HibernateHelper.getSessionFactory().openSession();
        try {
            session.beginTransaction();
            Hibernate.initialize(supplier.get());
            session.getTransaction().commit();
        } catch (Exception ex) {
            session.getTransaction().rollback();
            log.info("Error initializing HibernateProxy... ", ex);
            ex.printStackTrace();
        } finally {
            if (session.isOpen())
                session.close();
        }
    }


}
