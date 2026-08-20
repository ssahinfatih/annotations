package com.fatihsahin.annotations.exception;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice // Tüm REST Controller'larda oluşabilecek hataları merkezi olarak yönetir.
public class GlobalExceptionHandler {

    @ExceptionHandler(RuntimeException.class) // RuntimeException oluştuğunda bu method çalışır.
    public String handleRuntimeException(RuntimeException exception) {

        // Hata mesajını response olarak döndürüyoruz.
        return exception.getMessage();
    }
}