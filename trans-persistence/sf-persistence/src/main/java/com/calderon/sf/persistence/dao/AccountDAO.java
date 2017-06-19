package com.calderon.sf.persistence.dao;

import com.calderon.sf.persistence.dto.AccountEntity;
import com.calderon.sf.persistence.util.HibernateHelper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Hibernate;
import org.hibernate.Session;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

/**
 * Created by Nathaniel on 6/11/2017.
 */
public class AccountDAO extends BasicDAO {
    private static final Logger log = LogManager.getLogger(AccountDAO.class.getName());
    public static AccountEntity getAccountByAccNum(String accNum) {
        log.info("Getting account by AccNum: " + accNum);
        Session session = HibernateHelper.getSessionFactory().openSession();
        try {

            AccountEntity account = session.bySimpleNaturalId( AccountEntity.class ).getReference( accNum );
            Hibernate.initialize(account.getTransactionsById());
            /*CriteriaBuilder builder = session.getCriteriaBuilder();

            CriteriaQuery<AccountEntity> criteria = builder.createQuery( AccountEntity.class );
            Root<AccountEntity> root = criteria.from( AccountEntity.class );
            criteria.select( root );
            criteria.where( builder.equal( root.get( "accNum" ), accNum ) );*/
            return account;
        } catch (Exception ex) {
            log.info("Error trying to get account... ", ex);
            ex.printStackTrace();
        } finally {
            if (session.isOpen())
                session.close();
        }
        return null;
    }

}
