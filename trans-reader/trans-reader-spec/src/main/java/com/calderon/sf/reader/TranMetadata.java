package com.calderon.sf.reader;

import com.calderon.sf.commons.persistence.enums.AccountTypeEnum;

import java.time.LocalDateTime;

/**
 * Created by Nathaniel on 3/18/2017.
 */
public interface TranMetadata {
    String getSourceType();
    String getSourceName();
    LocalDateTime getCreated();
    String getBankName();
    String getAccountName();
    AccountTypeEnum getAccountType();
    String getAccountNumber();
}
