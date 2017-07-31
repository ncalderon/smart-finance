package com.calderon.sf.data.repository;

import com.calderon.sf.data.model.AccountEntity;
import org.springframework.data.repository.CrudRepository;


public interface AccountRepository extends CrudRepository<AccountEntity, Integer> {
    /*@Query("select new com.calderon.sf.web.data.dto.AccountEntity(id) " +
            " from AccountEntity a where accName = ?"
    )*/
    AccountEntity findOneByAccNumAndAccName(String accNum, String accName);
}
