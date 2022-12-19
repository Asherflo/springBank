package com.semicolon.springBank.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import com.semicolon.springBank.model.enums.AccountType;
import com.semicolon.springBank.model.enums.Gender;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.*;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private  Long id;

    private String firstName;


    private String lastName;
    private String Password;

    @Enumerated(value = EnumType.STRING)
    private Gender gender;

    private String age;

    private String phoneNumber;

    @Email
    @Column(unique = true)
    private String email;

    private String occupation;


    private String address;

    @JsonDeserialize(using = LocalDateDeserializer.class)
    @JsonSerialize(using = LocalDateSerializer.class)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    private LocalDate dateOfBirth;

    @JsonDeserialize(using = LocalDateDeserializer.class)
    @JsonSerialize(using = LocalDateSerializer.class)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    private LocalDate dateJoined;
    @Enumerated(value = EnumType.STRING)
    private AccountType accountType;

    private String accountNumber;
    private String pin;


    public Customer(String firstName, String lastName, String email, String address, Gender gender, String age, String occupation, AccountType accountType,String phoneNumber) {
        this.firstName=firstName;
        this.lastName = lastName;
        this.email =email;
        this.accountType=accountType;
        this.age=age;
        this.address = address;
        this.gender= gender;
        this.occupation= occupation;
        this.phoneNumber= phoneNumber;



    }
}
