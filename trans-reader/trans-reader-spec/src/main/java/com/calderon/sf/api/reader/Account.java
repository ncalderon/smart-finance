package com.calderon.sf.api.reader;

import com.calderon.sf.commons.persistence.enums.AccountTypeEnum;

import java.time.LocalDateTime;

/**
 * Created by Nathaniel on 6/24/2017.
 */
public class Account {
    private Bank bank;
    private String name;
    private LocalDateTime created;
    private AccountTypeEnum type;
    private String number;

    public static class Builder {
        private Bank bank;
        private String name;
        private LocalDateTime created;
        private AccountTypeEnum type;
        private String number;

        public Builder setBank(Bank bank) {
            this.bank = bank;
            return this;
        }

        public Builder setName(String name) {
            this.name = name;
            return this;
        }

        public Builder setCreated(LocalDateTime created) {
            this.created = created;
            return this;
        }

        public Builder setType(AccountTypeEnum type) {
            this.type = type;
            return this;
        }

        public Builder setNumber(String number) {
            this.number = number;
            return this;
        }

        public Account build () {
            return new Account(this);
        }
    }

    private Account(Builder builder) {
        this.bank = builder.bank;
        this.name = builder.name;
        this.created = builder.created;
        this.type = builder.type;
        this.number = builder.number;
    }

    public Bank getBank() {
        return bank;
    }

    public void setBank(Bank bank) {
        this.bank = bank;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDateTime getCreated() {
        return created;
    }

    public void setCreated(LocalDateTime created) {
        this.created = created;
    }

    public AccountTypeEnum getType() {
        return type;
    }

    public void setType(AccountTypeEnum type) {
        this.type = type;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Account account = (Account) o;

        if (!bank.equals(account.bank)) return false;
        if (!name.equals(account.name)) return false;
        if (!created.equals(account.created)) return false;
        if (type != account.type) return false;
        return number.equals(account.number);
    }

    @Override
    public int hashCode() {
        int result = bank.hashCode();
        result = 31 * result + name.hashCode();
        result = 31 * result + created.hashCode();
        result = 31 * result + type.hashCode();
        result = 31 * result + number.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Account{" +
                "bank=" + bank +
                ", name='" + name + '\'' +
                ", created=" + created +
                ", type=" + type +
                ", number='" + number + '\'' +
                '}';
    }
}
