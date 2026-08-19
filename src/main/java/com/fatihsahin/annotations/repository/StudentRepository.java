package com.fatihsahin.annotations.repository;

import org.springframework.stereotype.Repository;

@Repository // Bu class'ın Repository / database katmanı olduğunu belirtir.
public class StudentRepository {

    public String findStudent() {

        // Şimdilik gerçek database yerine örnek değer döndürüyoruz.
        return "Student database'den geldi.";
    }
}