package com.hhi.model;

import com.hhi.enums.AccountType;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.List;


@Entity(name = "Customer")
@Table
public class Customer {
    public Customer(){}
    public int getCustomerNumber() {
        return customerNumber;
    }

    public void setCustomerNumber(int customerNumber) {
        this.customerNumber = customerNumber;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int customerNumber;
    @NotNull
    @Size(max = 50)
    private String customerName;
    @NotNull
    @Size(max = 20)
    private String customerMobile;
    @Email
    @NotNull(message = "Email is required")
    @NotEmpty(message = "Email is required")
    @Size(max = 50, message = "Max character is up to 50 only" )
    private String customerEmail;
    @NotNull
    @Size(max = 100)
    private String address1;
    private String address2;

    @OneToMany(mappedBy = "customerNumber", cascade = CascadeType.ALL)
    private List<Account> accounts;

    public List<Account> getAccounts() {
        return accounts;
    }

    public void setAccounts(List<Account> accounts) {
        this.accounts = accounts;
    }


    public AccountType getAccountType() {
        return accountType;
    }

    public void setAccountType(AccountType accountType) {
        this.accountType = accountType;
    }

    private AccountType accountType;

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerMobile() {
        return customerMobile;
    }

    public void setCustomerMobile(String customerMobile) {
        this.customerMobile = customerMobile;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    public String getAddress1() {
        return address1;
    }

    public void setAddress1(String address1) {
        this.address1 = address1;
    }

    public String getAddress2() {
        return address2;
    }

    public void setAddress2(String address2) {
        this.address2 = address2;
    }




}
