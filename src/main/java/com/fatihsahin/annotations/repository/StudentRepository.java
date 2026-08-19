package com.fatihsahin.annotations.repository;

import com.fatihsahin.annotations.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student,Integer> {

    // firstName alanına göre Student kayıtlarını getirir.
    List<Student> findByFirstName(String firstName);
}
