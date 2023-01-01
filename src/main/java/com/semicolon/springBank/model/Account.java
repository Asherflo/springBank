package com.semicolon.springBank.model;

import com.semicolon.springBank.model.enums.AccountType;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.*;

import java.math.BigDecimal;


@Entity
@AllArgsConstructor
@NoArgsConstructor
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
    @Email
    private  String email;
    private BigDecimal accountBalance;
    @ManyToOne
    private Customer customer;







}
