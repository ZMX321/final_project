package com.example.testspringhibernate;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class TestSpringHibernateApplication {

    public static void main(String[] args) {
        SpringApplication.run(TestSpringHibernateApplication.class, args);
    }

}
