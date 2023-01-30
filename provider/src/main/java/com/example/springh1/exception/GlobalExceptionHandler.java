package com.example.springh1.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestBody;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler
    public ResponseEntity processIllegalInput(IllegalArgumentException e){
        return new ResponseEntity<>("Please check your input.", HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler
    public ResponseEntity processRunTimeException(RuntimeException e){
        return new ResponseEntity<>("Hold on tight, there is an internal error.", HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
