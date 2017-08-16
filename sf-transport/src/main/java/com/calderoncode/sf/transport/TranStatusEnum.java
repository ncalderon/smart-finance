package com.calderoncode.sf.transport;

/**
 * Created by Nathaniel on 6/10/2017.
 */
public enum TranStatusEnum {
    DELETED(0), PENDING(1), EXPORTED(2);

    private int id;

    TranStatusEnum(int id) {
        this.id = id;
    }

    public int id() {
        return id;
    }
}
