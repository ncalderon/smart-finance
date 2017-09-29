package com.calderon.sf.transport;

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
        if (!(o instanceof Account)) return false;

        Account account = (Account) o;

        if (bank != null ? !bank.equals(account.bank) : account.bank != null) return false;
        if (name != null ? !name.equals(account.name) : account.name != null) return false;
        if (type != account.type) return false;
        return number != null ? number.equals(account.number) : account.number == null;
    }

    @Override
    public int hashCode() {
        int result = bank != null ? bank.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (type != null ? type.hashCode() : 0);
        result = 31 * result + (number != null ? number.hashCode() : 0);
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
