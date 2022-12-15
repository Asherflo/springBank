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
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.springframework.validation.annotation.Validated;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
@Validated
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private  Long id;
    @NotNull
    @NotBlank
    private String firstName;

    @NotNull
    @NotBlank
    private String LastName;
    private String Password;

    @Enumerated(value = EnumType.STRING)
    private Gender gender;
    @NotNull
    @NotBlank
    private int age;
    @NotNull
    @NotBlank
    private String phoneNumber;

    @Email
    @NotNull
    @NotBlank
    @Column(unique = true)
    private String email;

    private String occupation;

    @NotNull
    @NotBlank
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





}
