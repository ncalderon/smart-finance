package com.calderon.sf.persistence.external.em.dao;

import com.calderon.sf.persistence.external.em.dto.ExpenseReportEntity;
import com.calderon.sf.persistence.external.em.util.HibernateHelper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

/**
 * Created by Nathaniel on 6/18/2017.
 */
public class ReportDAO {
    private static final Logger log = LogManager.getLogger(ReportDAO.class.getName());
    public static List<ExpenseReportEntity> getReportsByAccount (String account) {
        log.info("Getting Report by Account: " + account);
        Session session = HibernateHelper.getSessionFactory().openSession();
        try {

            CriteriaBuilder builder = session.getCriteriaBuilder();

            CriteriaQuery<ExpenseReportEntity> criteria = builder.createQuery( ExpenseReportEntity.class );
            Root<ExpenseReportEntity> root = criteria.from( ExpenseReportEntity.class );
            criteria.select( root );
            criteria.where( builder.equal( root.get( "account" ), account ) );

            return session.createQuery( criteria ).getResultList();
        } catch (Exception ex) {
            log.info("Error trying to get Bank... ", ex);
            ex.printStackTrace();
        } finally {
            if (session.isOpen())
                session.close();
        }
        return null;
    }

    public static boolean saveReports(List<ExpenseReportEntity> reports) {
        log.info("Trying to save reports: "  + reports);
        boolean result = false;
        Session session = HibernateHelper.getSessionFactory().openSession();
        try {
            session.beginTransaction();
            reports.stream()
                    .forEach(t -> {
                        session.saveOrUpdate(t);
                    });
            session.getTransaction().commit();
            result = true;
        } catch (Exception ex) {
            session.getTransaction().rollback();
            log.info("Error trying to save Reports... ", ex);
            ex.printStackTrace();
        } finally {
            if (session.isOpen())
                session.close();
        }
        return result;
    }
}
