package com.calderon.sf.repository;

import com.calderon.sf.domain.TranCategoryRegex;
import org.springframework.stereotype.Repository;

import org.springframework.data.jpa.repository.*;


/**
 * Spring Data JPA repository for the TranCategoryRegex entity.
 */
@SuppressWarnings("unused")
@Repository
public interface TranCategoryRegexRepository extends JpaRepository<TranCategoryRegex, Long> {

}
