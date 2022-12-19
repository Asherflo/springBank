package com.semicolon.springBank.controller;

import com.semicolon.springBank.dtos.CustomerDto;
import com.semicolon.springBank.requests.AccountCreationRequest;
import com.semicolon.springBank.response.ApiResponse;
import com.semicolon.springBank.service.CustomerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/")
public class CustomerController {
    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }
    @GetMapping("/customer")
    public ResponseEntity<?>createCustomer(@RequestBody AccountCreationRequest accountCreationRequest){
        CustomerDto customerDto = customerService.createCustomer(accountCreationRequest);
        ApiResponse apiResponse = ApiResponse.builder()
                .status("succeess")
                .message("Customer successfully created")
                .data(customerDto)
                .result(1)
                .build();

        return  new ResponseEntity<>(apiResponse, HttpStatus.OK);

    }
}
