package com.calderon.sf.transport;

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

    public int getId() {
        return id;
    }

    public static AccountTypeEnum from (int id){
        switch (id){
            case 2:
                return CREDIT_CARD;
        }
        return DEFAULT;
    }
}
