package com.harshmali.userservice.exceptions;


import lombok.Builder;
import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
@Builder
public class ApiResponse {
    String message;
    boolean success;
    HttpStatus status;
}
