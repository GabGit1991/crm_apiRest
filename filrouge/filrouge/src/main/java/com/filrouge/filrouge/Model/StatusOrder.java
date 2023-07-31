package com.filrouge.filrouge.Model;

public enum StatusOrder {

    STATUS1("CANCELLED", 0),

    STATUS2("OPTION", 1),

    STATUS3("CONFIRMED", 2);

 

    private final String value;

    private final Integer intValue;

 

    private StatusOrder(String value, Integer intValue) {

        this.value = value;

        this.intValue = intValue;

    }

 

    public String getValue() {

        return value;

    }

 

    public int getIntValue() {

        return intValue;

    }

}
