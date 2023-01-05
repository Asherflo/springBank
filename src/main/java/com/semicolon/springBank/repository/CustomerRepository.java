package com.semicolon.springBank.repository;

import com.semicolon.springBank.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer,Long> {
    boolean existsByAccount_AccountNumber(String accountNumber);
}
