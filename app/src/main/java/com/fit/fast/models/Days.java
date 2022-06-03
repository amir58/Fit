package com.fit.fast.models;

public enum Days {
    GE(6), SP(2), MMA(2), BB(2);

    private int days;
    Days(int i) {
        days = i;
    }

    public int getDays() {
        return days;
    }
}
