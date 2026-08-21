package com.fatihsahin.annotations.exception;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.AccessDeniedException;

@RestControllerAdvice // Tüm REST Controller'larda oluşabilecek hataları merkezi olarak yönetir.
public class GlobalExceptionHandler {


    @ExceptionHandler(AccessDeniedException.class) // Yetki hatasını yakalar.
    public ResponseEntity<String> handleAccessDeniedException(
            AccessDeniedException exception) {

        // 403 Forbidden döndürüyoruz.
        return ResponseEntity
                .status(HttpStatus.FORBIDDEN)
                .body("Access Denied");
    }

    @ExceptionHandler(RuntimeException.class) // Diğer RuntimeException'ları yakalar.
    public ResponseEntity<String> handleRuntimeException(
            RuntimeException exception) {

        // Diğer hatalar için 500 döndürüyoruz.
        return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(exception.getMessage());
    }
}