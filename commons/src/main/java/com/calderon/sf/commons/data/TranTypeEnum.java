package com.calderon.sf.commons.persistence.enums;

/**
 * Created by Nathaniel on 3/18/2017.
 */
public enum TranTypeEnum {
    DEBIT(1, "DB"), CREDIT(2, "CR");

    private int id;
    private String codename;

    TranTypeEnum(int id, String codename) {
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
