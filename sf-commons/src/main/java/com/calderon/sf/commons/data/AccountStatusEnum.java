package com.calderon.sf.commons.data;

/**
 * Created by Nathaniel on 6/10/2017.
 */
public enum AccountStatusEnum {
    INACTIVE(0), ACTIVE(1);

    private int id;

    AccountStatusEnum(int id) {
        this.id = id;
    }

    public int id() {
        return id;
    }
}
