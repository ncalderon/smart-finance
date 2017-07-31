package com.calderon.sf.data.service;

import com.calderon.sf.data.model.AccountEntity;
import java.util.List;

public interface AccountService {
    AccountEntity findOneByAccNumAndAccName(String accNum, String accName);
}
