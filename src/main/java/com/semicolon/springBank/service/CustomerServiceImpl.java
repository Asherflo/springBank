package com.semicolon.springBank.service;

import com.semicolon.springBank.dtos.CustomerDto;
import com.semicolon.springBank.model.Account;
import com.semicolon.springBank.model.Customer;
import com.semicolon.springBank.repository.CustomerRepository;
import com.semicolon.springBank.requests.CustomerCreationRequest;
import com.semicolon.springBank.response.CustomerResponseDto;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class CustomerServiceImpl  implements  CustomerService{
    private final CustomerRepository customerRepository;
    private  final ModelMapper modelMapper;

    public CustomerServiceImpl(CustomerRepository customerRepository,ModelMapper modelMapper) {
        this.customerRepository = customerRepository;
        this.modelMapper= modelMapper;
    }

    @Override
    public CustomerDto createCustomer(CustomerCreationRequest customerCreationRequest) {
        Account account = new Account();
        account.setAccountBalance(customerCreationRequest.getInitialDeposit());
        account.setAccountType(customerCreationRequest.getAccountType());
        account.setAccountName(customerCreationRequest.getFirstName()+ " "+ customerCreationRequest.getLastName());
        account.setAccountNumber(generateAccountNumber());
        Customer customer = new Customer();
        customer.setLastName(customerCreationRequest.getLastName());
         customer.setEmail(customerCreationRequest.getEmail());
         customer.setAccountNumber();
        customer.setDateJoined(LocalDate.now());
        Customer savedCustomer = customerRepository.save(customer);
        return modelMapper.map(savedCustomer,CustomerDto.class);
    }

    private String generateAccountNumber() {
        String accountNumber = UUID.randomUUID().toString();
        if(customerRepository.existsByAccount_AccountNumber(accountNumber)){
            generateAccountNumber();
        }
        return accountNumber;
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
