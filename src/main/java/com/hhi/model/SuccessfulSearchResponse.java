package com.hhi.model;

public class SuccessfulSearchResponse {
    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public String getTransactionStatusCode() {
        return transactionStatusCode;
    }

    public void setTransactionStatusCode(String transactionStatusCode) {
        this.transactionStatusCode = transactionStatusCode;
    }

    public String getTransactionStatusDescription() {
        return transactionStatusDescription;
    }

    public void setTransactionStatusDescription(String transactionStatusDescription) {
        this.transactionStatusDescription = transactionStatusDescription;
    }

    private Customer customer;
    private String transactionStatusCode;
    private String transactionStatusDescription;
}
