package com.calderon.sf.repository;

import com.calderon.sf.domain.TranCategory;
import org.springframework.stereotype.Repository;

import org.springframework.data.jpa.repository.*;


/**
 * Spring Data JPA repository for the TranCategory entity.
 */
@SuppressWarnings("unused")
@Repository
public interface TranCategoryRepository extends JpaRepository<TranCategory, Long> {

}
