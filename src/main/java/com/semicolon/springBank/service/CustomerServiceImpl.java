package com.semicolon.springBank.service;

import com.semicolon.springBank.dtos.CustomerDto;
import com.semicolon.springBank.model.Customer;
import com.semicolon.springBank.repository.CustomerRepository;
import com.semicolon.springBank.requests.AccountCreationRequest;
import com.semicolon.springBank.response.CustomerResponseDto;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceImpl  implements  CustomerService{
    private final CustomerRepository customerRepository;
    private  final ModelMapper modelMapper;

    public CustomerServiceImpl(CustomerRepository customerRepository,ModelMapper modelMapper) {
        this.customerRepository = customerRepository;
        this.modelMapper= modelMapper;
    }

    @Override
    public CustomerDto createCustomer(AccountCreationRequest accountCreationRequest) {
        Customer customer = new Customer(accountCreationRequest.getFirstName(),
                accountCreationRequest.getLastName(), accountCreationRequest.getEmail(),
                accountCreationRequest.getAddress(), accountCreationRequest.getGender(), accountCreationRequest.getAge(),
                accountCreationRequest.getOccupation(),
                accountCreationRequest.getAccountType(),
                accountCreationRequest.getPhoneNumber());
        customer.setDateJoined(LocalDate.now());
        Customer savedCustomer = customerRepository.save(customer);
        return modelMapper.map(savedCustomer,CustomerDto.class);
    }


    @Override
    public CustomerDto findById(String id) {
        Optional<Customer> customer= customerRepository.findById(Long.parseLong(id));
        return modelMapper.map(customer,CustomerDto.class);
    }

    @Override
    public CustomerResponseDto getAllCustomer() {
        List<Customer> customerList = customerRepository.findAll();
        CustomerResponseDto customerResponseDto = new CustomerResponseDto();
        customerResponseDto.setResponseList(customerList);
        return customerResponseDto;
    }

    @Override
    public Customer searchCustomerByEmail(String email) {
        return null;
    }
}
