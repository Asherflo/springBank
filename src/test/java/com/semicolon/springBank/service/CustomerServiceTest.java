package com.semicolon.springBank.service;

import com.semicolon.springBank.dtos.CustomerDto;
import com.semicolon.springBank.requests.AccountCreationRequest;
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
        AccountCreationRequest accountCreationRequest = new AccountCreationRequest();
        accountCreationRequest.setFirstName("Emmanuel");
        accountCreationRequest.setLastName("Olayinka");
        accountCreationRequest.setAddress("32,ogudu street.yaba");
        accountCreationRequest.setAge("32");
        accountCreationRequest.setEmail("olayinka.e@yahoo.com");
        accountCreationRequest.setGender(MALE);
        accountCreationRequest.setOccupation("Software Engineer");
        accountCreationRequest.setPhoneNumber("09131106322");
        CustomerDto customerDto = customerService.createCustomer(accountCreationRequest);
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