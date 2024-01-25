package com.harshmali.userservice.exceptions;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFound.class)
    public ResponseEntity<ApiResponse> resnotfoundhandler(ResourceNotFound ex){
             String message=ex.getMessage();
            ApiResponse response= ApiResponse.builder().message(message).success(false).status(HttpStatus.NOT_FOUND).build();
            return new ResponseEntity<>(response,HttpStatus.NOT_FOUND);

    }
}
