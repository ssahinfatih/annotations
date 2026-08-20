package com.fatihsahin.annotations.component;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

@Component // Spring bu class'ı yönetir.
public class StartupComponent {

    @PostConstruct // Spring bu methodu Bean hazırlandıktan sonra bir kere çalıştırır.
    public void init() {

        // Uygulama başlarken çalışacak.
        System.out.println("Annotations projesi başlatıldı!");
    }
}