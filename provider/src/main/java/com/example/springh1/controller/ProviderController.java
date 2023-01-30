package com.example.springh1.controller;


import com.example.springh1.pojo.BaseResponse;
import com.example.springh1.pojo.Provider;
import com.example.springh1.pojo.User;
import com.example.springh1.pojo.dto.ProviderDTO;
import com.example.springh1.service.ProviderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/v1/userinfo")
public class ProviderController {

    private final ProviderService providerService;

    @Autowired
    public ProviderController(ProviderService providerService){
        this.providerService = providerService;
    }

    @GetMapping
    public ResponseEntity getAllProvider(){
        List<ProviderDTO> list = providerService.getAllProvider();


        return new ResponseEntity<>(new BaseResponse(list), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity createProvider(@RequestBody User user){

        if(user.getProvider().getFirst_name() == null || user.getProvider().getLast_name() == null || user.getProvider().getDob() == null){
            throw new IllegalArgumentException();
        }

        Integer newId = providerService.insertNewProvider(user.getProvider());


        return new ResponseEntity<>(new BaseResponse(newId), HttpStatus.CREATED);

    }
}
