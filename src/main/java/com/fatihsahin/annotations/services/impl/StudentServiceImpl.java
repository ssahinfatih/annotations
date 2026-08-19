package com.fatihsahin.annotations.services.impl;

import com.fatihsahin.annotations.entities.Student;
import com.fatihsahin.annotations.repository.StudentRepository;
import com.fatihsahin.annotations.services.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service // Bu class'ı Spring Service Bean olarak yönetir.
public class StudentServiceImpl implements IStudentService {

    @Autowired // StudentRepository Bean'ini Spring inject eder.
    private StudentRepository studentRepository;

    @Override
    public Student save(Student student) {
        // Student'ı database'e kaydeder.
        return studentRepository.save(student);
    }
}