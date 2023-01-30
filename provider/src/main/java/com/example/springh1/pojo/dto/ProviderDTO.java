package com.example.springh1.pojo.dto;

import com.example.springh1.pojo.Provider;
import lombok.Data;

@Data
public class ProviderDTO {

    private Integer id;
    private String first_name;
    private String last_name;

    public ProviderDTO(Provider provider){
        this.id = provider.getId();
        this.first_name = provider.getFirst_name();
        this.last_name = provider.getLast_name();
    }
}
