package com.calderon.sf.persistence.dto;

/**
 * Created by Nathaniel on 6/10/2017.
 */
public enum TranStatusEnum {
    DEFAULT(0), DELETED(1);

    private int id;

    TranStatusEnum(int id) {
        this.id = id;
    }

    public int id() {
        return id;
    }
}
