package com.example.search.pojo.entity;

import com.example.search.pojo.dto.ProviderDTO;
import com.example.search.pojo.dto.StudentDTO;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class BaseResponse implements Serializable {

    private List<StudentDTO> students;

    private List<ProviderDTO> providers;

    public BaseResponse(){}

    public BaseResponse(StudentResponse s, ProviderResponse p) {
        this.students = s.getData();
        this.providers = p.getData();
    }
}
