package com.calderoncode.sf.transport;

/**
 * Created by Nathaniel on 6/18/2017.
 */
public enum TranMethodEnum {
    DEFAULT(0, "DEFAULT"),CASH(1, "Cash"), CHECK(2, "Check"), CREDIT_CARD(3, "Credit Card"), DEBIT(4, "Debit"), ELECTRONIC_TRANSFER(5, "Electronic Transfer");

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

    public static TranMethodEnum from(String codename){
        switch (codename) {
            case "Cash":
                return CASH;
            case "Check":
                return CHECK;
            case "Credit Card":
                return CREDIT_CARD;
            case "Debit":
                return DEBIT;
            case "Electronic Transfer":
                return ELECTRONIC_TRANSFER;
        }
        return DEFAULT;
    }
}
