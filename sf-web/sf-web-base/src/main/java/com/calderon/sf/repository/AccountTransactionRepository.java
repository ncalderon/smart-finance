package com.calderon.sf.repository;

import com.calderon.sf.domain.AccountTransaction;
import org.springframework.stereotype.Repository;

import org.springframework.data.jpa.repository.*;


/**
 * Spring Data JPA repository for the AccountTransaction entity.
 */
@SuppressWarnings("unused")
@Repository
public interface AccountTransactionRepository extends JpaRepository<AccountTransaction, Long> {

}
