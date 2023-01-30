package com.example.springh1.pojo;

import lombok.Data;

import java.io.Serializable;

@Data
public class BaseResponse<T> implements Serializable {

    private  T data;

    public BaseResponse(){}

    public BaseResponse(T data) {
        this.data = data;
    }
}
