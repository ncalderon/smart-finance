package com.calderon.sf.reader;

import java.time.LocalDateTime;

/**
 * Created by Nathaniel on 3/18/2017.
 */
class CsvMetadata implements TranMetadata {

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CsvMetadata that = (CsvMetadata) o;

        if (sourceType != null ? !sourceType.equals(that.sourceType) : that.sourceType != null) return false;
        if (sourceName != null ? !sourceName.equals(that.sourceName) : that.sourceName != null) return false;
        if (created != null ? !created.equals(that.created) : that.created != null) return false;
        if (bankName != null ? !bankName.equals(that.bankName) : that.bankName != null) return false;
        if (accountName != null ? !accountName.equals(that.accountName) : that.accountName != null) return false;
        if (accountType != that.accountType) return false;
        return accountNumber != null ? accountNumber.equals(that.accountNumber) : that.accountNumber == null;
    }

    @Override
    public int hashCode() {
        int result = sourceType != null ? sourceType.hashCode() : 0;
        result = 31 * result + (sourceName != null ? sourceName.hashCode() : 0);
        result = 31 * result + (created != null ? created.hashCode() : 0);
        result = 31 * result + (bankName != null ? bankName.hashCode() : 0);
        result = 31 * result + (accountName != null ? accountName.hashCode() : 0);
        result = 31 * result + (accountType != null ? accountType.hashCode() : 0);
        result = 31 * result + (accountNumber != null ? accountNumber.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "CsvMetadata{" +
                "sourceType='" + sourceType + '\'' +
                ", sourceName='" + sourceName + '\'' +
                ", created=" + created +
                ", bankName='" + bankName + '\'' +
                ", accountName='" + accountName + '\'' +
                ", accountType=" + accountType +
                ", accountNumber='" + accountNumber + '\'' +
                '}';
    }
}
