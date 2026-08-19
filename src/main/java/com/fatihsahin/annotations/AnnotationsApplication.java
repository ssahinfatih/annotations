package com.fatihsahin.annotations;

import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication//@SpringBootConfiguration @EnabledAutoConfiguration @ComponentScan işlemlerini otomatik yapıyor.

public class AnnotationsApplication {

    public static void main(String[] args) {
        SpringApplication.run(AnnotationsApplication.class, args);
    }

}
