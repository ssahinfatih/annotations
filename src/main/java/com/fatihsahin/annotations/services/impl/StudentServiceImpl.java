package com.fatihsahin.annotations.services.impl;

import com.fatihsahin.annotations.entities.Student;
import com.fatihsahin.annotations.repository.StudentRepository;
import com.fatihsahin.annotations.services.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tools.jackson.databind.ObjectMapper;

import java.util.List;

@Service // Bu class'ı Spring Service Bean olarak yönetir.
public class StudentServiceImpl implements IStudentService {

    @Autowired // StudentRepository Bean'ini Spring inject eder.
    private StudentRepository studentRepository;

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

    @Autowired // Spring, ObjectMapper Bean'ini buraya inject eder.
    private ObjectMapper objectMapper;
}