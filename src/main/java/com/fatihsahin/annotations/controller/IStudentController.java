package com.fatihsahin.annotations.controller;

import com.fatihsahin.annotations.entities.Student;

import java.util.List;

public interface IStudentController {

    Student save(Student student);// Student kaydetme endpoint'ini tanımlar.

    List<Student> findAll();// Tüm Student ları getirir.

    Student findById(Integer id);// Student ları id ye göre getir.

    Student updateById(Integer id,Student student);
}