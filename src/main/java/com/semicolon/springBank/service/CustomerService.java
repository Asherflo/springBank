package com.semicolon.springBank.service;

import com.semicolon.springBank.dtos.CustomerDto;
import com.semicolon.springBank.model.Customer;
import com.semicolon.springBank.requests.CustomerCreationRequest;
import com.semicolon.springBank.response.CustomerResponseDto;

public interface CustomerService {
    CustomerDto createCustomer(CustomerCreationRequest customerCreationRequest);
    CustomerDto findById(String id);

    CustomerResponseDto getAllCustomer();
    Customer searchCustomerByEmail(String email);
}
