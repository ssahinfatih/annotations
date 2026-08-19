package com.fatihsahin.annotations.controller.impl;

import com.fatihsahin.annotations.controller.IStudentController;
import com.fatihsahin.annotations.entities.Student;
import com.fatihsahin.annotations.services.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController // Bu class'ın REST Controller olduğunu belirtir.JSON / String / Object döndürür
@RequestMapping("/students") // Bu controller'ın temel URL'ini belirler.
public class StudentControllerImpl implements IStudentController {


    @Autowired // Service Bean'ini Spring inject eder.
    private IStudentService studentService;

    @PostMapping(path = "/save") // POST /students isteğini karşılar.
    public Student save(@RequestBody Student student) {
        // Gelen Student nesnesini Service katmanına gönderir.
        return studentService.save(student);
    }
}