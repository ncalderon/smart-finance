package com.calderon.sf.reader;

/**
 * Created by Nathaniel on 3/18/2017.
 */
public enum TranTypeEnum {
    DEBIT(1), CREDIT(2);

    private int id;

    TranTypeEnum(int id) {
        this.id = id;
    }

    public int id() {
        return id;
    }
}
