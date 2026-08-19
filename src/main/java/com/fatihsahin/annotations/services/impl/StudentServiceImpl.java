package com.fatihsahin.annotations.services.impl;

import com.fatihsahin.annotations.repository.StudentRepository;
import com.fatihsahin.annotations.services.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service // Bu class'ı Spring Service Bean olarak yönetir.
public class StudentServiceImpl implements IStudentService {

    @Autowired // StudentRepository Bean'ini Spring otomatik olarak inject eder.
    private StudentRepository studentRepository;

    @Override
    public String getStudent() {

        // Repository katmanındaki işlemi çağırıyoruz.
        return studentRepository.findStudent();
    }
}