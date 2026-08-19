package com.fatihsahin.annotations.controller.impl;

import com.fatihsahin.annotations.controller.IStudentController;
import com.fatihsahin.annotations.services.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController // Bu class'ın REST Controller olduğunu belirtir.JSON / String / Object döndürür
@RequestMapping("/students") // Bu controller'ın temel URL'ini belirler.
public class StudentControllerImpl implements IStudentController {

    @Autowired // IStudentService'in implementation'ını Spring inject eder.
    private IStudentService studentService;

    @Override
    @GetMapping("/database") // GET /students/database endpoint'ini oluşturur.
    public String getStudent() {

        // Controller'dan Service katmanına geçiyoruz.
        return studentService.getStudent();
    }
}