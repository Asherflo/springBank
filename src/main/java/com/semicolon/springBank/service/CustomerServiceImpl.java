package com.semicolon.springBank.service;

import com.semicolon.springBank.dtos.CustomerDto;
import com.semicolon.springBank.model.Customer;
import com.semicolon.springBank.repository.CustomerRepository;
import com.semicolon.springBank.requests.AccountCreationRequest;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
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
}
