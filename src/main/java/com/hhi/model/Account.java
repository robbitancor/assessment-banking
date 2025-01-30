package com.hhi.model;

import com.hhi.enums.AccountType;
import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table
public class Account {
    public Account(){}

    private int customerNumber;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int accountNumber;

    private AccountType accountType;

    private BigDecimal availableBalance;

    public int getCustomerNumber() {
        return customerNumber;
    }

    public void setCustomerNumber(int customerNumber) {
        this.customerNumber = customerNumber;
    }

    public AccountType getAccountType() {
        return accountType;
    }

    public void setAccountType(AccountType accountType) {
        this.accountType = accountType;
    }



    public int getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }


    public BigDecimal getAvailableBalance() {
        return availableBalance;
    }

    public void setAvailableBalance(BigDecimal availableBalance) {
        this.availableBalance = availableBalance;
    }


}
