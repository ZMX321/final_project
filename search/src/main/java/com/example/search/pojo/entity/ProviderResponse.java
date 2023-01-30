package com.example.search.pojo.entity;

import com.example.search.pojo.dto.ProviderDTO;
import com.example.search.pojo.dto.StudentDTO;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class ProviderResponse {

    @JsonProperty("data")
    private List<ProviderDTO> data;
}
