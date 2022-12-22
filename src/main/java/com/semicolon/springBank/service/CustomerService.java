package com.semicolon.springBank.service;

import com.semicolon.springBank.dtos.CustomerDto;
import com.semicolon.springBank.model.Customer;
import com.semicolon.springBank.requests.AccountCreationRequest;
import com.semicolon.springBank.response.CustomerResponseDto;

public interface CustomerService {
    CustomerDto createCustomer(AccountCreationRequest accountCreationRequest);
    CustomerDto findById(String id);

    CustomerResponseDto getAllCustomer();
    Customer searchCustomerByEmail(String email);
}
