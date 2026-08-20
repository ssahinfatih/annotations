package com.fatihsahin.annotations.services;

import com.fatihsahin.annotations.dto.DtoStudent;
import com.fatihsahin.annotations.dto.DtoStudentIU;
import com.fatihsahin.annotations.entities.Student;

import java.util.List;

// Service katmanında hangi işlemlerin bulunacağını tanımlar.
public interface IStudentService {

    // Student kaydetme işlemini tanımlar.
    DtoStudent save(DtoStudent dtoStudent);
    // Tüm Student ları getirir.
    List<Student> findAll();

    Student findById(Integer id);

    Student updateById(Integer id, Student student);

    void deleteById(Integer id);


    List<Student> findByFirstName(String firstName);  // firstName değerine göre Student arar.


}