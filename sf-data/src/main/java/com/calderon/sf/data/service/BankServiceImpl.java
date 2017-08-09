package com.calderon.sf.data.service;

import com.calderon.sf.data.model.BankEntity;
import com.calderon.sf.data.repository.BankRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BankServiceImpl implements BankService {
    private BankRepository repository;
    @Autowired
    public void setRepository(BankRepository repository) {
        this.repository = repository;
    }

    public BankEntity findFirstByName(String name) {
        return repository.findFirstByName(name);
    }
}
