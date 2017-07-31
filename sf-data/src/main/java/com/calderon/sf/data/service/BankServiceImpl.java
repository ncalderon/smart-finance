package com.calderon.sf.data.service;

import com.calderon.sf.data.model.BankEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BankServiceImpl implements BankService {
    public List<BankEntity> findByName(String name) {
        return null;
    }
}
