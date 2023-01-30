package com.example.springh1;

import static org.junit.jupiter.api.Assertions.*;

import com.example.springh1.controller.ProviderController;
import com.example.springh1.pojo.Provider;
import com.example.springh1.pojo.User;
import com.example.springh1.service.ProviderService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;

@SpringBootTest
class SpringH1ApplicationTests {

    private final ProviderService providerService;

    private final ProviderController providerController;

    @Autowired
    public SpringH1ApplicationTests(ProviderController providerController, ProviderService providerService){
        this.providerController = providerController;
        this.providerService = providerService;
    }

    @Test
    public void checkInsert(){

        Provider provider = new Provider();
        provider.setFirst_name("John");
        provider.setLast_name("Potter");
        provider.setDob(new Date());


        Integer id = providerService.insertNewProvider(provider);
        System.out.println(id);

        Provider newProvider = providerService.getProviderById(id);

        System.out.println(newProvider.toString());

        assertEquals(newProvider.getFirst_name(), provider.getFirst_name());
        assertEquals(newProvider.getLast_name(), provider.getLast_name());

    }

    @Test
    public void checkException(){
        User user = new User();

        Provider provider = new Provider();
        provider.setFirst_name("Alex");
        provider.setLast_name("Zen");

        user.setProvider(provider);

        assertThrows(IllegalArgumentException.class, () -> providerController.createProvider(user));
    }

}
