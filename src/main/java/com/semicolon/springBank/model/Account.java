package com.semicolon.springBank.model;

import com.semicolon.springBank.model.enums.AccountType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import lombok.*;


@Entity
@AllArgsConstructor
@NoArgsConstructor

@Getter
@Setter
public class Account {
    @Id
    private  Long id;
    @Enumerated(value = EnumType.STRING)
    private AccountType accountType;




}
