package com.calderon.sf.data.repository;

import com.calderon.sf.data.model.BankEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface BankRepository extends CrudRepository<BankEntity, Integer> {
    BankEntity findFirstByName(String name);
}
