package com.anz.wseapp.util;

public enum Currency {
    SGD("SINGAPORE_DOLLAR"),
    AUD("AUSTRALIAN_DOLLAR"),
    USD("US_DOLLAR"),
    INR("INDIAN_RUPEE"),
    ;

    private String currencyDesc;
    Currency(String currencyDesc) {
        this.currencyDesc = currencyDesc;
    }
    public String getCurrencyDesc(){
        return currencyDesc;
    }
}
