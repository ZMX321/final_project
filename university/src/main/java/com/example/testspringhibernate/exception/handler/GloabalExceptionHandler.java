package com.example.testspringhibernate.exception.handler;


import com.example.testspringhibernate.exception.BusinessException;
import com.example.testspringhibernate.pojo.BaseResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


@ControllerAdvice
@Slf4j
public class GloabalExceptionHandler {

    @ExceptionHandler
    public ResponseEntity processBusinessException(BusinessException e){
        return new ResponseEntity(new BaseResponse(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler
    public ResponseEntity processRunTimeException(RuntimeException e){
        log.error("RuntimeException: ", e);
        return new ResponseEntity(new BaseResponse(), HttpStatus.INTERNAL_SERVER_ERROR);
    }


}
