package com.calderoncode.sf.transport;

public enum TranCategoryEnum {
    INCOME(100), EXPENSE(2);
    private int id;

    TranCategoryEnum(int id) {
        this.id = id;
    }

    public int id() {
        return id;
    }
    public String codename(){
        return name();
    }

    public static TranCategoryEnum from (int id){
        switch (id){
            case 100:
                return INCOME;
            case 2:
                return EXPENSE;
        }
        return INCOME;
    }
}
