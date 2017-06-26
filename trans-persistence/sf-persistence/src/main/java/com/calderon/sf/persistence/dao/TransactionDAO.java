package com.calderon.sf.persistence.dao;

import com.calderon.sf.persistence.dto.AccountEntity;
import com.calderon.sf.persistence.dto.BankEntity;
import com.calderon.sf.persistence.dto.TransactionEntity;
import com.calderon.sf.persistence.util.HibernateHelper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Root;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Created by Nathaniel on 6/11/2017.
 */
public class TransactionDAO extends BasicDAO{
    private static final Logger log = LogManager.getLogger(TransactionDAO.class.getName());
    public static void saveTransactions(BankEntity bank, AccountEntity account, List<TransactionEntity> transactions){
        log.info("Trying to save transactions for Account: " +  account + " , Transactions: " + transactions);
        Session session = HibernateHelper.getSessionFactory().openSession();
        try {
            session.beginTransaction();
            log.info("Saving bank: " + bank);
            session.saveOrUpdate(bank);
            log.info("Saving account: " + account);
            session.saveOrUpdate(account);
            log.info("Saving transactions: " + transactions);
            int batchSize = 25;
            IntStream.range(0, transactions.size()).forEach(i->{
                session.saveOrUpdate(transactions.get(i));
                if ( i > 0 && i % batchSize == 0 ) {
                    //flush a batch of inserts and release memory
                    session.flush();
                    session.clear();
                }
            });
            /*transactions.stream()
                    .forEach(t -> {
                        *//*t.setAccountId(account.getId());*//*
                        session.saveOrUpdate(t);
                    });*/
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


    public static List<TransactionEntity> getPendingTransactions() {
        log.info("Getting pending transactions...  ");
        Session session = HibernateHelper.getSessionFactory().openSession();
        try {

            CriteriaBuilder builder = session.getCriteriaBuilder();
            CriteriaQuery<TransactionEntity> criteria = builder.createQuery( TransactionEntity.class );
            Root<TransactionEntity> root = criteria.from( TransactionEntity.class );
            criteria.select( root );
            /*root.fetch( "accountByAccountId", JoinType.LEFT);
            root.fetch( "tranTypeByTypeId", JoinType.LEFT);
            root.fetch( "tranStatusByStatusId", JoinType.LEFT);
            root.fetch( "tranCategoryByCategoryId", JoinType.LEFT);*/
            criteria.where( builder.equal( root.get( "statusId" ), 1 ) );

            return session.createQuery( criteria ).getResultList();
        } catch (Exception ex) {
            log.info("Error trying to get pending transactions... ", ex);
            ex.printStackTrace();
        } finally {
            if (session.isOpen())
                session.close();
        }
        return null;
    }
}
