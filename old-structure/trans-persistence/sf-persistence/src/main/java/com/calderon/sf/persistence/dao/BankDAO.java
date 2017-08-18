package com.calderon.sf.persistence.dao;

import com.calderon.sf.persistence.dto.BankEntity;
import com.calderon.sf.persistence.util.HibernateHelper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

/**
 * Created by Nathaniel on 6/11/2017.
 */
public class BankDAO extends BasicDAO {
    private static final Logger log = LogManager.getLogger(AccountDAO.class.getName());
    public static BankEntity getBankByName(String name) {
        log.info("Getting Bank by Name: " + name);
        Session session = HibernateHelper.getSessionFactory().openSession();
        try {

            CriteriaBuilder builder = session.getCriteriaBuilder();

            CriteriaQuery<BankEntity> criteria = builder.createQuery( BankEntity.class );
            Root<BankEntity> root = criteria.from( BankEntity.class );
            criteria.select( root );
            criteria.where( builder.equal( root.get( "name" ), name ) );

            List<BankEntity> banks = session.createQuery( criteria ).getResultList();
            if (banks.size() <= 0)
                return null;
            return banks.get(0);
        } catch (Exception ex) {
            log.info("Error trying to get Bank... ", ex);
            ex.printStackTrace();
        } finally {
            if (session.isOpen())
                session.close();
        }
        return null;
    }


}
