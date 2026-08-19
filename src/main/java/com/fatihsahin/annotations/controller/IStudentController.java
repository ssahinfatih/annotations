package com.fatihsahin.annotations.controller;

import com.fatihsahin.annotations.entities.Student;

import java.util.List;

public interface IStudentController {

    Student save(Student student);// Student kaydetme endpoint'ini tanımlar.

    List<Student> findAll();// Tüm Student ları getirir.

    Student findById(Integer id);// Student ları id ye göre getir.

    Student updateById(Integer id,Student student);// Student ı id sine göre güncelle.

    void deleteById(Integer id);// Verilen ID'ye sahip Student'ı siler. geriye veri dönmeyeceği için void olarak tanımlıyoruz.
}