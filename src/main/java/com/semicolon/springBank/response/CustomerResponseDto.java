package com.semicolon.springBank.response;

import com.semicolon.springBank.model.Customer;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class CustomerResponseDto {
    private List<Customer> responseList;
}
