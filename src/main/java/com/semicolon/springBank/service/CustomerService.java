package com.semicolon.springBank.service;

import com.semicolon.springBank.dtos.CustomerDto;
import com.semicolon.springBank.requests.AccountCreationRequest;

public interface CustomerService {
    CustomerDto createCustomer(AccountCreationRequest accountCreationRequest);
}
