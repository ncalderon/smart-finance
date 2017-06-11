package com.calderon.sf.persistence.dto;

/**
 * Created by Nathaniel on 6/10/2017.
 */
public enum AccountTypeEnum {
    DEFAULT(1), CREDIT_CARD(2);

    private int id;

    AccountTypeEnum(int id) {
        this.id = id;
    }

    public int id() {
        return id;
    }
}
