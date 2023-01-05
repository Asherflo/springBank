package com.semicolon.springBank.service;

import com.semicolon.springBank.dtos.CustomerDto;
import com.semicolon.springBank.model.enums.AccountType;
import com.semicolon.springBank.requests.CustomerCreationRequest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static com.semicolon.springBank.model.enums.Gender.MALE;
import static org.hibernate.validator.internal.util.Contracts.assertNotNull;

@SpringBootTest
class CustomerServiceTest {
    @Autowired
    private CustomerService customerService;
    @Test
    @DisplayName("A customer can be created")
    void  testThatACustomerCanBeCreated(){
        CustomerCreationRequest customerCreationRequest = new CustomerCreationRequest();
        customerCreationRequest.setFirstName("Emmanuel");
        customerCreationRequest.setLastName("Olayinka");
        customerCreationRequest.setAddress("32,ogudu street.yaba");
        customerCreationRequest.setAge("32");
        customerCreationRequest.setEmail("olayinka.e@yahoo.com");
        customerCreationRequest.setGender(MALE);
        customerCreationRequest.setOccupation("Software Engineer");
        customerCreationRequest.setPhoneNumber("09131106322");
        CustomerDto customerDto = customerService.createCustomer(customerCreationRequest);
        assertNotNull(customerDto);
    }
    @Test
    @DisplayName("To check the initial balance")
    void testToCheckTheInitialAccountBalance(){

    }

    @Test
    @DisplayName(" Test To deposit money in the account")
    void testToDeposit(){

    }

}