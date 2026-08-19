package com.fatihsahin.annotations.services;

import com.fatihsahin.annotations.entities.Student;

import java.util.List;

// Service katmanında hangi işlemlerin bulunacağını tanımlar.
public interface IStudentService {


    // Student kaydetme işlemini tanımlar.
    Student save(Student student);
    // Tüm Student ları getirir.
    List<Student> findAll();

    Student findById(Integer id);


}