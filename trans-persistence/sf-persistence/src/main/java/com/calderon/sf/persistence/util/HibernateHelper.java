package com.calderon.sf.persistence.util;

import com.calderon.sf.persistence.dao.AccountDAO;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

/**
 * Created by Nathaniel on 1/9/2017.
 */
public class HibernateHelper {
    private static final Logger log = LogManager.getLogger(HibernateHelper.class.getName());
    private static final SessionFactory sessionFactory = buildSessionFactory();
    private static SessionFactory buildSessionFactory () {
        // A SessionFactory is set up once for an application!
        log.info("Setting up Hibernate SessionFactory...");
        final StandardServiceRegistry registry =
                        new StandardServiceRegistryBuilder()
                        .configure() // configures settings from hibernate.cfg.xml
                        .build();
        SessionFactory sessionFactory = null;
        try {
            sessionFactory = new MetadataSources( registry ).buildMetadata().buildSessionFactory();
        }
        catch (Exception e) {
            // The registry would be destroyed by the SessionFactory, but we had trouble building the SessionFactory
            // so destroy it manually.
            log.info("Error trying to set up Hibernate SessionFactory... ", e);
            StandardServiceRegistryBuilder.destroy( registry );
            e.printStackTrace();

        }
        return sessionFactory;
    }

    public static SessionFactory getSessionFactory () {
        return sessionFactory;
    }
}
