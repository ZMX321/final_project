package com.example.testspringhibernate.pojo;

import lombok.Data;
import org.springframework.http.HttpStatus;

import java.io.Serializable;

@Data
public class BaseResponse<T> implements Serializable {

    private  T data;

    public BaseResponse(){}

    public BaseResponse(T data) {
        this.data = data;
    }
}
