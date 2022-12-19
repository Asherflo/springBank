package com.semicolon.springBank.response;

import lombok.*;

import java.io.Serializable;
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ApiResponse implements Serializable {
    private String status;
    private String message;
    private Object data;
    private int result;
}
