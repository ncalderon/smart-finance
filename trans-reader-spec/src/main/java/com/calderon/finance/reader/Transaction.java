package com.calderon.finance.reader;

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
            if(!unsetFields.isEmpty())
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
}

