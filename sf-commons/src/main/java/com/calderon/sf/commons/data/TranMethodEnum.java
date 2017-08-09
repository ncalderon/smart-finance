package com.calderon.sf.commons.data;

/**
 * Created by Nathaniel on 6/18/2017.
 */
public enum TranMethodEnum {
    DEFAULT(0, ""),CASH(1, "Cash"), CHECK(2, "Check"), CREDIT_CARD(3, "Credit Card"), DEBIT(4, "Debit"), ELECTRONIC_TRANSFER(5, "Electronic Transfer");

    private int id;
    private String codename;

    TranMethodEnum(int id, String codename) {
        this.id = id;
        this.codename = codename;
    }

    public int id() {
        return id;
    }


    public String codename() {
        return codename;
    }
}
