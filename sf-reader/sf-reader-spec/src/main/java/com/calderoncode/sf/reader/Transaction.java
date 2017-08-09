package com.calderoncode.sf.reader;

import com.calderon.sf.commons.data.TranTypeEnum;

import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * Created by Nathaniel on 3/13/2017.
 */
public class Transaction {

    private LocalDate postDate;
    private TranTypeEnum type;
    private BigDecimal amount;
    private String referenceNumber;
    private String serialNumber;
    private String description;
    private Account account;

    private Transaction(Builder builder) {
        this.postDate = builder.postDate;
        this.type = builder.type;
        this.amount = builder.amount;
        this.referenceNumber = builder.referenceNumber;
        this.serialNumber = builder.serialNumber;
        this.description = builder.description;
        this.account = builder.account;
    }

    public static class Builder {
        private LocalDate postDate;
        private TranTypeEnum type;
        private BigDecimal amount;
        private String referenceNumber;
        private String serialNumber;
        private String description;
        private Account account;

        public Builder setAccount(Account account) {
            this.account = account;
            return this;
        }

        public Builder setPostDate (LocalDate postDate) {
            this.postDate = postDate;
            return this;
        }

        public Builder setType(TranTypeEnum type) {
            this.type = type;
            return this;
        }

        public Builder setAmount(BigDecimal amount) {
            this.amount = amount;
            return this;
        }

        public Builder setReferenceNumber(String referenceNumber) {
            this.referenceNumber = referenceNumber;
            return this;
        }

        public Builder setSerialNumber(String serialNumber) {
            this.serialNumber = serialNumber;
            return this;
        }

        public Builder setDescription(String description) {
            this.description = description;
            return this;
        }

        public Transaction build () {
            return new Transaction(this);
        }
    }

    public LocalDate getPostDate() {
        return postDate;
    }

    public TranTypeEnum getType() {
        return type;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public String getReferenceNumber() {
        return referenceNumber;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public String getDescription() {
        return description;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Transaction that = (Transaction) o;

        if (postDate != null ? !postDate.equals(that.postDate) : that.postDate != null) return false;
        if (type != that.type) return false;
        if (amount != null ? !amount.equals(that.amount) : that.amount != null) return false;
        if (referenceNumber != null ? !referenceNumber.equals(that.referenceNumber) : that.referenceNumber != null)
            return false;
        if (serialNumber != null ? !serialNumber.equals(that.serialNumber) : that.serialNumber != null) return false;
        if (description != null ? !description.equals(that.description) : that.description != null) return false;
        return account != null ? account.equals(that.account) : that.account == null;
    }

    @Override
    public int hashCode() {
        int result = postDate != null ? postDate.hashCode() : 0;
        result = 31 * result + (type != null ? type.hashCode() : 0);
        result = 31 * result + (amount != null ? amount.hashCode() : 0);
        result = 31 * result + (referenceNumber != null ? referenceNumber.hashCode() : 0);
        result = 31 * result + (serialNumber != null ? serialNumber.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (account != null ? account.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "postDate=" + postDate +
                ", type=" + type +
                ", amount=" + amount +
                ", referenceNumber='" + referenceNumber + '\'' +
                ", serialNumber='" + serialNumber + '\'' +
                ", description='" + description + '\'' +
                ", account=" + account +
                '}';
    }
}

