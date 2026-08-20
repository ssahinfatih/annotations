package com.fatihsahin.annotations.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration // Configuration class.
@Profile("dev") // Sadece dev aktifken kullanılır.
public class DevConfig {

    @Bean // Spring Bean oluşturur.
    public String devEnvironment() {

        // Development ortamında olduğumuzu gösterir.
        return "Development Environment";
    }
}
