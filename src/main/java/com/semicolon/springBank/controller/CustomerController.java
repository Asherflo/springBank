package com.semicolon.springBank.controller;

import com.semicolon.springBank.dtos.CustomerDto;
import com.semicolon.springBank.requests.CustomerCreationRequest;
import com.semicolon.springBank.response.ApiResponse;
import com.semicolon.springBank.response.CustomerResponseDto;
import com.semicolon.springBank.service.CustomerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/customer")
public class CustomerController {
    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }
    @PostMapping("/createCustomer")
    public ResponseEntity<?>createCustomer(@RequestBody CustomerCreationRequest customerCreationRequest){
        CustomerDto customerDto = customerService.createCustomer(customerCreationRequest);
        ApiResponse apiResponse = ApiResponse.builder()
                .status("success")
                .message("Customer successfully created")
                .data(customerDto)
                .result(1)
                .build();

        return  new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<?>getCustomerById(@PathVariable("id") String  id){
            CustomerDto customerDto=  customerService.findById(id);
            ApiResponse apiResponse = ApiResponse.builder()
                    .status("success")
                    .data("Customer details found ")
                    .data(customerDto)
                    .build();
        return new ResponseEntity<>(apiResponse,HttpStatus.OK);
    }
//
    @GetMapping("/allCustomer")
    public CustomerResponseDto getAllCustomer(){
        return  customerService.getAllCustomer();
    }

}
