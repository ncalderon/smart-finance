package com.calderon.finance;

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
    private Transaction(Builder builder) {
        this.postDate = builder.postDate;
        this.type = builder.type;
        this.amount = builder.amount;
        this.referenceNumber = builder.referenceNumber;
        this.serialNumber = builder.serialNumber;
        this.description = builder.description;
    }

    public static class Builder {
        private LocalDate postDate;
        private TranTypeEnum type;
        private BigDecimal amount;
        private String referenceNumber;
        private String serialNumber;
        private String description;
        private String unsetFields = "postDate, type, amount, referenceNumber, serialNumber, description,";
        public Builder setPostDate (LocalDate postDate) {
            this.postDate = postDate;
            unsetFields = unsetFields.replace("postDate,", "");
            return this;
        }

        public Builder setType(TranTypeEnum type) {
            this.type = type;
            unsetFields = unsetFields.replace("type,", "");
            return this;
        }

        public Builder setAmount(BigDecimal amount) {
            this.amount = amount;
            unsetFields = unsetFields.replace("amount,", "");
            return this;
        }

        public Builder setReferenceNumber(String referenceNumber) {
            this.referenceNumber = referenceNumber;
            unsetFields = unsetFields.replace("referenceNumber,", "");
            return this;
        }

        public Builder setSerialNumber(String serialNumber) {
            this.serialNumber = serialNumber;
            unsetFields = unsetFields.replace("serialNumber,", "");
            return this;
        }

        public Builder setDescription(String description) {
            this.description = description;
            unsetFields = unsetFields.replace("description,", "");
            return this;
        }

        public Transaction build () {
            if(!unsetFields.trim().isEmpty())
                throw new NullPointerException("Those fields are required before build: " + unsetFields);
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

    @Override
    public String toString() {
        return "Transaction{" +
                "postDate=" + postDate +
                ", type=" + type +
                ", amount=" + amount +
                ", referenceNumber='" + referenceNumber + '\'' +
                ", serialNumber='" + serialNumber + '\'' +
                ", description='" + description + '\'' +
                '}';
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
        return description != null ? description.equals(that.description) : that.description == null;
    }

    @Override
    public int hashCode() {
        int result = postDate != null ? postDate.hashCode() : 0;
        result = 31 * result + (type != null ? type.hashCode() : 0);
        result = 31 * result + (amount != null ? amount.hashCode() : 0);
        result = 31 * result + (referenceNumber != null ? referenceNumber.hashCode() : 0);
        result = 31 * result + (serialNumber != null ? serialNumber.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        return result;
    }
}

