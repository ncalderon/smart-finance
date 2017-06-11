package com.calderon.sf.persistence.dao;

import com.calderon.sf.persistence.dto.AccountEntity;
import com.calderon.sf.persistence.dto.BankEntity;
import com.calderon.sf.persistence.util.HibernateHelper;
import org.hibernate.Session;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

/**
 * Created by Nathaniel on 6/11/2017.
 */
public class AccountDAO extends BasicDAO {
    public static AccountEntity getAccountByAccNum(String accNum) {
        Session session = HibernateHelper.getSessionFactory().openSession();
        try {

            CriteriaBuilder builder = session.getCriteriaBuilder();

            CriteriaQuery<AccountEntity> criteria = builder.createQuery( AccountEntity.class );
            Root<AccountEntity> root = criteria.from( AccountEntity.class );
            criteria.select( root );
            criteria.where( builder.equal( root.get( "accNum" ), accNum ) );

            List<AccountEntity> accounts = session.createQuery( criteria ).getResultList();
            if (accounts.size() <= 0)
                return null;
            return accounts.get(0);
        } catch (Exception ex) {

        } finally {
            session.close();
        }
        return null;
    }

}
