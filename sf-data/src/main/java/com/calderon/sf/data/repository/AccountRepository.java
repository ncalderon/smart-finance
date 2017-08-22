package com.calderon.sf.data.repository;

import com.calderon.sf.data.model.AccountEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;


public interface AccountRepository extends CrudRepository<AccountEntity, Integer> {
    /*@Query("select new com.calderon.sf.web.data.dto.AccountEntity(id) " +
            " from AccountEntity a where accName = ?"
    )*/
    AccountEntity findOneByAccNumAndAccName(String accNum, String accName);
    List<AccountEntity> findAll();
}
