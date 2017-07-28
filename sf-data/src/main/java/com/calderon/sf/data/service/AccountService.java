package com.calderon.sf.data.service;

import com.calderon.sf.data.model.AccountEntity;
import java.util.List;

public interface AccountService {
    List<AccountEntity> findByAccName(String accName);
}
