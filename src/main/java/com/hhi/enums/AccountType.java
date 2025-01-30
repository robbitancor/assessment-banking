package com.hhi.enums;

public enum AccountType {
    Savings("Savings"),Checking("Checking");

    final String value;
    AccountType(String valueStr){
        value = valueStr;
    }
}
