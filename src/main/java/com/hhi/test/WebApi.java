package com.hhi.test;


import com.hhi.model.*;
import jakarta.validation.Valid;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@RestController
public class WebApi {
    @Autowired
    private SessionFactory factory;

    @PostMapping("/api/v1/account")
    public ResponseEntity<Object> testApi2(@Valid @RequestBody Customer request, BindingResult result) {

        if(!result.getFieldErrors().isEmpty()){
            return ResponseEntity.badRequest().body(
                    new ErrorResponse(
                            "400",
                            result.getFieldErrors().get(0).getDefaultMessage()));
        }

        factory.inTransaction(session -> {
            Account account = new Account();
            request.setAccounts(List.of(account));
            session.persist(request);
            account.setCustomerNumber(request.getCustomerNumber());
            account.setAvailableBalance(new BigDecimal(500));
            account.setAccountType(request.getAccountType());
        });


        return ResponseEntity.status(HttpStatus.CREATED).body(new SuccessResponse(String.valueOf(request.getCustomerNumber()),"201","Customer account created"));
    }

    @PostMapping("/api/v1/account/{customerNumber}")
    public ResponseEntity<Object> searchCustomer(@PathVariable("customerNumber") String customerNumber){
        Customer request = new Customer();
        request.setCustomerNumber(Integer.parseInt(customerNumber));
        request = factory.openSession().get(Customer.class,Integer.parseInt(customerNumber));
        if(request != null){
            SuccessfulSearchResponse resp = new SuccessfulSearchResponse();
            resp.setCustomer(request);
            resp.setTransactionStatusCode("302");
            resp.setTransactionStatusDescription("Customer Account found");
            return ResponseEntity.of(Optional.of(resp));
        }else {
            ErrorResponse errorResponse = new ErrorResponse("401","Customer not found");
            return ResponseEntity.badRequest().body(errorResponse);
        }


    }
}
