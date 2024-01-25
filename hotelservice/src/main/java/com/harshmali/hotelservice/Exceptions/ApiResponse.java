package com.harshmali.hotelservice.Exceptions;


import lombok.Builder;
import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
@Builder
public class ApiResponse {

    String message;
    HttpStatus status;
    Boolean success;

}
