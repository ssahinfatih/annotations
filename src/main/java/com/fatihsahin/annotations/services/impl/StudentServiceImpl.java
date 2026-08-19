package com.fatihsahin.annotations.services.impl;

import com.fatihsahin.annotations.entities.Student;
import com.fatihsahin.annotations.repository.StudentRepository;
import com.fatihsahin.annotations.services.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tools.jackson.databind.ObjectMapper;

import java.util.List;
import java.util.Optional;

@Service // Bu class'ı Spring Service Bean olarak yönetir.
public class StudentServiceImpl implements IStudentService {

    @Autowired // StudentRepository Bean'ini Spring inject eder.
    private StudentRepository studentRepository;

    @Autowired // Spring, ObjectMapper Bean'ini buraya inject eder.
    private ObjectMapper objectMapper;

    @Override
    public Student save(Student student) {
        // Student'ı database'e kaydeder.
        return studentRepository.save(student);
    }

    @Override
    public List<Student> findAll() {
        return studentRepository.findAll();// Database'deki tüm Student kayıtlarını getirir.
    }

    @Override
    public Student findById(Integer id) {
        return studentRepository.findById(id).get();
    }

    @Override
    public Student updateById(Integer id, Student student) {

        // Database'deki mevcut Student'ı ID ile buluyoruz.
        Student dbStudent = studentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Student bulunamadı!"));//Optional içinde değer varsa onu al, yoksa hata fırlat demek.

        // Mevcut kaydın bilgilerini güncelliyoruz.
        dbStudent.setFirstName(student.getFirstName());
        dbStudent.setLastName(student.getLastName());

        // Güncellenmiş nesneyi database'e kaydediyoruz.
        return studentRepository.save(dbStudent);
    }

    @Override
    public void deleteById(Integer id) {
      studentRepository.deleteById(id);
    }


}