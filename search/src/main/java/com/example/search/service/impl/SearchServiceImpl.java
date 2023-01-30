package com.example.search.service.impl;

import com.example.search.config.EndpointConfig;
import com.example.search.pojo.entity.BaseResponse;
import com.example.search.pojo.entity.ProviderResponse;
import com.example.search.pojo.entity.StudentResponse;
import com.example.search.service.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Service
public class SearchServiceImpl implements SearchService {

    private final RestTemplate restTemplate;

    private final ExecutorService pool = Executors.newCachedThreadPool();

    @Autowired
    public SearchServiceImpl(RestTemplate restTemplate){
        this.restTemplate = restTemplate;
    }

    @Override
    public BaseResponse getAllUsersStus(){
        CompletableFuture<StudentResponse> cfS = CompletableFuture.supplyAsync(() -> restTemplate.getForObject(EndpointConfig.universityService, StudentResponse.class), pool);
        CompletableFuture<ProviderResponse> cfP = CompletableFuture.supplyAsync(() -> restTemplate.getForObject(EndpointConfig.providerService, ProviderResponse.class), pool);

        return cfS.thenCombine(cfP, BaseResponse::new).join();
    }
}
