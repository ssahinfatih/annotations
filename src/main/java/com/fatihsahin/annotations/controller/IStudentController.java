package com.fatihsahin.annotations.controller;

import com.fatihsahin.annotations.dto.DtoStudent;
import com.fatihsahin.annotations.dto.DtoStudentIU;
import com.fatihsahin.annotations.entities.Student;

import java.util.List;

public interface IStudentController {

    // Student kaydetme işlemini tanımlar.
    DtoStudent save(DtoStudent dtoStudent);

    List<Student> findAll();// Tüm Student ları getirir.

    Student findById(Integer id);// Student ları id ye göre getir.

    Student updateById(Integer id,Student student);// Student ı id sine göre güncelle.

    void deleteById(Integer id);// Verilen ID'ye sahip Student'ı siler. geriye veri dönmeyeceği için void olarak tanımlıyoruz.


    List<Student> findByFirstName(String firstName);  // firstName değerine göre Student arama işlemini tanımlar.
}