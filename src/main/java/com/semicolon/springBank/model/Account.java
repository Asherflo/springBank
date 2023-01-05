package com.semicolon.springBank.model;

import com.semicolon.springBank.model.enums.AccountType;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.*;

import java.math.BigDecimal;
import java.util.UUID;


@Entity
@AllArgsConstructor
@Getter
@Setter
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;
    @Enumerated(value = EnumType.STRING)
    private AccountType accountType;
    private String accountName;
    private String accountNumber;

    private BigDecimal accountBalance;
    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;



    public Account() {

    }
}
