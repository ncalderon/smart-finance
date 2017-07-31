package com.calderon.sf.data.service;

import com.calderon.sf.data.model.TranCategoryEntity;

import java.util.List;

public interface TranCategoryService
{
    List<TranCategoryEntity> findByParentId(Integer parentId);
    List<TranCategoryEntity> findChildren();
    TranCategoryEntity findCategoryById(Integer id);
}
