package com.calderon.sf.data.service;

import com.calderon.sf.data.model.TranCategoryEntity;
import com.calderon.sf.data.repository.TranCategoryRepository;
import com.calderon.sf.data.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TranCategoryServiceImpl implements TranCategoryService {

    private static final int CATEGORIES_PARENT_ID = 0;

    private TranCategoryRepository repository;

    @Autowired
    public void setRepository(TranCategoryRepository repository) {
        this.repository = repository;
    }
    public List<TranCategoryEntity> findByParentId(Integer parentId) {
        return repository.findByParentId(parentId);
    }

    public List<TranCategoryEntity> findChildren() {
        return repository.findByParentIdIsNot(0);
    }

    public TranCategoryEntity findCategoryById(Integer id) {
        return repository.findOne(id);
    }
}
