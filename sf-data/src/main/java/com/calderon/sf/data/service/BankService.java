package com.calderon.sf.data.service;

import com.calderon.sf.data.model.BankEntity;

import java.util.List;

public interface BankService {
    List<BankEntity> findByName(String name);
}
