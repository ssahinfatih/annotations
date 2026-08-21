package com.fatihsahin.annotations.controller.impl;

import com.fatihsahin.annotations.controller.IStudentController;
import com.fatihsahin.annotations.dto.DtoStudent;
import com.fatihsahin.annotations.entities.Student;
import com.fatihsahin.annotations.services.IStudentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@CrossOrigin // Farklı originlerden gelen isteklere CORS izni verir.
/*
@CrossOrigin(origins = "http://localhost:3000" // Sadece bu frontend adresine izin verir.
)*/
@RestController
// Bu class'ın REST Controller olduğunu belirtir.JSON / String / Object döndürür. @Controller ve @ResponseBody nin birleşimidir.
@RequestMapping("/students") // Bu controller'ın temel URL'ini belirler.
public class StudentControllerImpl implements IStudentController {


    @Autowired // Service Bean'ini Spring inject  eder.
    private IStudentService studentService;

    @Override
    @PostMapping("/save") // POST /students isteğini karşılar.
    public DtoStudent save(@Valid @RequestBody DtoStudent dtoStudent) { // Body'yi al ve validation yap.

        // Gelen ve doğrulanan DTO'yu Service katmanına gönderiyoruz.
        return studentService.save(dtoStudent);
    }

    @Override
    @GetMapping("/list")
    @CrossOrigin(
            origins = "http://localhost:3000" // Bu endpoint için CORS izni.
    )
    public List<Student> findAll() {
        return studentService.findAll();
    }

    @Override
    @GetMapping("/list/{id}")
    public Student findById( @PathVariable(name = "id") Integer id) {
        return studentService.findById(id);
    }

    @Override
    @PutMapping("/update/{id}")
    public Student updateById( @PathVariable(name = "id") Integer id, @RequestBody Student student) {
        return studentService.updateById(id, student);
    }

    @Override
    @DeleteMapping("/delete/{id}")
    public void deleteById(@PathVariable(name = "id") Integer id) {
        studentService.deleteById(id);
    }

    @GetMapping("/search") // GET /students/search isteğini karşılar.
    @Override
    public List<Student> findByFirstName(
            @RequestParam(name = "firstName") String firstName) { // URL'deki firstName parametresini alır.

        // Gelen parametreyi Service katmanına gönderiyoruz.
        return studentService.findByFirstName(firstName);
    }
}