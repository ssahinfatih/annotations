package com.fatihsahin.annotations.services;

import com.fatihsahin.annotations.entities.Student;

// Service katmanında hangi işlemlerin bulunacağını tanımlar.
public interface IStudentService {


    // Student kaydetme işlemini tanımlar.
    Student save(Student student);
}