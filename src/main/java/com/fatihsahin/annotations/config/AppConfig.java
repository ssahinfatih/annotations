package com.fatihsahin.annotations.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import tools.jackson.databind.ObjectMapper;

@Configuration // Spring'in configuration class'ı olduğunu belirtir.
public class AppConfig {

    @Bean // ObjectMapper nesnesini Spring Bean olarak kaydeder.
    public ObjectMapper objectMapper() {

        // ObjectMapper nesnesini oluşturuyoruz.
        return new ObjectMapper();
    }
}