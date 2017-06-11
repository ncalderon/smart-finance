package com.calderon.sf.persistence.dao;

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
public class BankDAO extends BasicDAO {
    public static BankEntity getBankByName(String name) {
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

        } finally {
            session.close();
        }
        return null;
    }


}
