package com.calderon.finance.bpd.csv;

import com.calderon.finance.reader.AccountTypeEnum;
import com.calderon.finance.reader.SourceMetadata;

import java.time.LocalDateTime;

/**
 * Created by Nathaniel on 3/18/2017.
 */
class CsvMetadata implements SourceMetadata {

    private String sourceType;
    private String sourceName;
    private LocalDateTime created;
    private String bankName;
    private String accountName;
    private AccountTypeEnum accountType;
    private String accountNumber;

    private CsvMetadata(Builder builder) {
        this.sourceType = builder.sourceType;
        this.sourceName = builder.sourceName;
        this.created = builder.created;
        this.bankName = builder.bankName;
        this.accountName = builder.accountName;
        this.accountType = builder.accountType;
        this.accountNumber = builder.accountNumber;
    }
    public static class Builder {
        private String sourceType;
        private String sourceName;
        private LocalDateTime created;
        private String bankName;
        private String accountName;
        private AccountTypeEnum accountType;
        private String accountNumber;
        //private String unsetFields = "sourceType, sourceName, created, bankName, accountName, accountType,";

        public Builder setSourceType(String sourceType) {
            this.sourceType = sourceType;
            return this;
        }

        public Builder setSourceName(String sourceName) {
            this.sourceName = sourceName;
            return this;
        }

        public Builder setCreated(LocalDateTime created) {
            this.created = created;
            return this;
        }

        public Builder setBankName(String bankName) {
            this.bankName = bankName;
            return this;
        }

        public Builder setAccountName(String accountName) {
            this.accountName = accountName;
            return this;
        }

        public Builder setAccountType(AccountTypeEnum accountType) {
            this.accountType = accountType;
            return this;
        }

        public Builder setAccountNumber(String accountNumber) {
            this.accountNumber = accountNumber;
            return this;
        }

        public CsvMetadata build () {
            return new CsvMetadata(this);
        }
    }

    @Override
    public String getSourceType() {
        return sourceType;
    }

    @Override
    public String getSourceName() {
        return sourceName;
    }

    @Override
    public LocalDateTime getCreated() {
        return created;
    }

    @Override
    public String getBankName() {
        return bankName;
    }

    @Override
    public String getAccountName() {
        return accountName;
    }

    @Override
    public AccountTypeEnum getAccountType() {
        return accountType;
    }

    public String getAccountNumber() {
        return accountNumber;
    }
}
