package com.calderon.sf.data.repository;

import com.calderon.sf.data.model.TranCategoryEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TranCategoryRepository extends CrudRepository<TranCategoryEntity, Integer> {
    List<TranCategoryEntity> findByParentId(Integer parentId);
    List<TranCategoryEntity> findByParentIdIsNot(Integer parentId);
    TranCategoryEntity findOne(Integer integer);
}
