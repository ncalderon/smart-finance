package com.calderon.sf.persistence.dao;

import com.calderon.sf.persistence.dto.TranCategoryEntity;
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
public class CategoryDAO extends BasicDAO {
    private static final Logger log = LogManager.getLogger(CategoryDAO.class.getName());

    public static List<TranCategoryEntity> getAllChildCategories () {
        return getAllCategoriesByParent(true);
    }

    public static List<TranCategoryEntity> getAllParentCategories () {
        return getAllCategoriesByParent(false);
    }

    private static List<TranCategoryEntity> getAllCategoriesByParent (boolean child) {
        log.info("Getting categories by child: " + child);
        Session session = HibernateHelper.getSessionFactory().openSession();
        try {

            CriteriaBuilder builder = session.getCriteriaBuilder();

            CriteriaQuery<TranCategoryEntity> criteria = builder.createQuery( TranCategoryEntity.class );
            Root<TranCategoryEntity> root = criteria.from( TranCategoryEntity.class );
            criteria.select( root );
            if(child)
                criteria.where( builder.notEqual( root.get( "parentId" ), 0 ) );
            else
                criteria.where( builder.equal( root.get( "parentId" ), 0 ) );

            List<TranCategoryEntity> catories = session.createQuery( criteria ).getResultList();
            return catories;
        } catch (Exception ex) {
            log.info("Error trying to get categories... ", ex);
            ex.printStackTrace();
        } finally {
            if (session.isOpen())
                session.close();
        }
        return null;
    }

    public static TranCategoryEntity get (int id) {
        log.info("Getting category by id: " + id);
        Session session = HibernateHelper.getSessionFactory().openSession();
        try {
            return session.get(TranCategoryEntity.class, id);
        } catch (Exception ex) {
            log.info("Error trying to get category... ", ex);
            ex.printStackTrace();
        } finally {
            if (session.isOpen())
                session.close();
        }
        return null;
    }
}
