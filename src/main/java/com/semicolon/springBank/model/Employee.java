package com.semicolon.springBank.model;

import com.semicolon.springBank.model.enums.Department;
import com.semicolon.springBank.model.enums.Gender;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Employee {
    private Long id;
    private String firstName;
    private String lastName;
    private String employmentNumber;
    private Gender gender;
    private LocalDate dateOfBirth;
    private LocalDate dateJoined;
    private Department department;

}
