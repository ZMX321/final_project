package com.example.search.controller;

import com.example.search.config.EndpointConfig;
import com.example.search.pojo.entity.BaseResponse;
import com.example.search.pojo.entity.ProviderResponse;
import com.example.search.pojo.entity.StudentResponse;
import com.example.search.service.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@RestController
@RequestMapping("/search")
public class SearchController {

    private final SearchService searchService;
    @Autowired
    public SearchController(SearchService searchService){
        this.searchService = searchService;
    }

    @GetMapping
    public ResponseEntity<?> getDetails() {
        //TODO
        return new ResponseEntity<>("this is search service", HttpStatus.OK);
    }

    @GetMapping("/users/students")
    public ResponseEntity getBothServices(){
        return new ResponseEntity(searchService.getAllUsersStus(), HttpStatus.OK);
    }
}
