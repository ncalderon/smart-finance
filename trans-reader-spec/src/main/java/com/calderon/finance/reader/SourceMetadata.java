package com.calderon.finance.reader;

import java.time.LocalDateTime;

/**
 * Created by Nathaniel on 3/18/2017.
 */
public interface SourceMetadata {
    String getSourceType();
    String getSourceName();
    LocalDateTime getCreated();
    String getBankName();
    String getAccountName();
    AccountTypeEnum getAccountType();
    String getAccountNumber();
}
