package com.example.search.pojo.entity;

import com.example.search.pojo.dto.StudentDTO;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class StudentResponse {

    @JsonProperty("data")
    private List<StudentDTO> data;
}
