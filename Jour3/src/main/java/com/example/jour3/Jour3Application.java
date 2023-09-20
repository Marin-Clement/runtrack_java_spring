package com.example.jour3;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.example.jour3.repository")
@EntityScan(basePackages = "com.example.jour3.model")
public class Jour3Application {

    public static void main(String[] args) {
        SpringApplication.run(Jour3Application.class, args);
    }
}

