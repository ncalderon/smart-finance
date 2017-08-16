package com.calderoncode.sf.transport;


import com.calderon.sf.commons.util.TimeUtil;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Calendar;

/**
 * Created by Nathaniel on 3/13/2017.
 */
public class Transaction {

    private TranTypeEnum type;
    private TranCategoryEnum category;
    private Account account;
    private String tranNum;
    private String tranRefNum;
    private Timestamp tranPostDate;
    private String tranDesc;
    private BigDecimal tranAmount;
    private TranMethodEnum tranMethod;

    private Transaction(Builder builder) {
        this.type = builder.type;
        this.category = builder.category;
        this.account = builder.account;
        this.tranNum = builder.tranNum;
        this.tranRefNum = builder.tranRefNum;
        this.tranPostDate = builder.tranPostDate;
        this.tranDesc = builder.tranDesc;
        this.tranAmount = builder.tranAmount;
        this.tranMethod = builder.tranMethod;

    }

    public static class Builder {
        private TranTypeEnum type;
        private TranCategoryEnum category;
        private Account account;
        private String tranNum;
        private String tranRefNum;
        private Timestamp tranPostDate;
        private String tranDesc;
        private BigDecimal tranAmount;
        private TranMethodEnum tranMethod;

        public TranTypeEnum getType() {
            return type;
        }

        public Builder setType(TranTypeEnum type) {
            this.type = type;
            return this;
        }

        public TranCategoryEnum getCategory() {
            return category;
        }

        public Builder setCategory(TranCategoryEnum category) {
            this.category = category;
            return this;
        }

        public Account getAccount() {
            return account;
        }

        public Builder setAccount(Account account) {
            this.account = account;
            return this;
        }

        public String getTranNum() {
            return tranNum;
        }

        public Builder setTranNum(String tranNum) {
            this.tranNum = tranNum;
            return this;
        }

        public String getTranRefNum() {
            return tranRefNum;
        }

        public Builder setTranRefNum(String tranRefNum) {
            this.tranRefNum = tranRefNum;
            return this;
        }

        public Timestamp getTranPostDate() {
            return tranPostDate;
        }

        public Builder setTranPostDate(Timestamp tranPostDate) {
            this.tranPostDate = tranPostDate;
            return this;
        }

        public Builder setTranPostDate(LocalDate tranPostDate) {
            this.tranPostDate = TimeUtil.newTimestampFrom(tranPostDate);
            return this;
        }

        public Builder setTranPostDate(LocalDateTime tranPostDate) {
            this.tranPostDate = TimeUtil.newTimestampFrom(tranPostDate);
            return this;
        }

        public String getTranDesc() {
            return tranDesc;
        }

        public Builder setTranDesc(String tranDesc) {
            this.tranDesc = tranDesc;
            return this;
        }

        public BigDecimal getTranAmount() {
            return tranAmount;
        }

        public Builder setTranAmount(BigDecimal tranAmount) {
            this.tranAmount = tranAmount;
            return this;
        }

        public TranMethodEnum getTranMethod() {
            return tranMethod;
        }

        public Builder setTranMethod(TranMethodEnum tranMethod) {
            this.tranMethod = tranMethod;
            return this;
        }

        public Transaction build () {
            return new Transaction(this);
        }
    }

    public TranTypeEnum getType() {
        return type;
    }

    public void setType(TranTypeEnum type) {
        this.type = type;
    }

    public TranCategoryEnum getCategory() {
        return category;
    }

    public void setCategory(TranCategoryEnum category) {
        this.category = category;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public String getTranNum() {
        return tranNum;
    }

    public void setTranNum(String tranNum) {
        this.tranNum = tranNum;
    }

    public String getTranRefNum() {
        return tranRefNum;
    }

    public void setTranRefNum(String tranRefNum) {
        this.tranRefNum = tranRefNum;
    }

    public Timestamp getTranPostDate() {
        return tranPostDate;
    }

    public void setTranPostDate(Timestamp tranPostDate) {
        this.tranPostDate = tranPostDate;
    }

    public String getTranDesc() {
        return tranDesc;
    }

    public void setTranDesc(String tranDesc) {
        this.tranDesc = tranDesc;
    }

    public BigDecimal getTranAmount() {
        return tranAmount;
    }

    public void setTranAmount(BigDecimal tranAmount) {
        this.tranAmount = tranAmount;
    }

    public TranMethodEnum getTranMethod() {
        return tranMethod;
    }

    public void setTranMethod(TranMethodEnum tranMethod) {
        this.tranMethod = tranMethod;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Transaction)) return false;

        Transaction that = (Transaction) o;

        if (account != null ? !account.equals(that.account) : that.account != null) return false;
        if (tranNum != null ? !tranNum.equals(that.tranNum) : that.tranNum != null) return false;
        if (tranRefNum != null ? !tranRefNum.equals(that.tranRefNum) : that.tranRefNum != null) return false;
        if (tranDesc != null ? !tranDesc.equals(that.tranDesc) : that.tranDesc != null) return false;
        return tranAmount != null ? tranAmount.equals(that.tranAmount) : that.tranAmount == null;
    }

    @Override
    public int hashCode() {
        int result = account != null ? account.hashCode() : 0;
        result = 31 * result + (tranNum != null ? tranNum.hashCode() : 0);
        result = 31 * result + (tranRefNum != null ? tranRefNum.hashCode() : 0);
        result = 31 * result + (tranDesc != null ? tranDesc.hashCode() : 0);
        result = 31 * result + (tranAmount != null ? tranAmount.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "type=" + type +
                ", category=" + category +
                ", account=" + account +
                ", tranNum='" + tranNum + '\'' +
                ", tranRefNum='" + tranRefNum + '\'' +
                ", tranPostDate=" + tranPostDate +
                ", tranDesc='" + tranDesc + '\'' +
                ", tranAmount=" + tranAmount +
                ", tranMethod=" + tranMethod +
                '}';
    }
}

