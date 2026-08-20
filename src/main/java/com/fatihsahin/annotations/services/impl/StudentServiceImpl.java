package com.fatihsahin.annotations.services.impl;

import com.fatihsahin.annotations.dto.DtoStudent;
import com.fatihsahin.annotations.entities.Student;
import com.fatihsahin.annotations.repository.StudentRepository;
import com.fatihsahin.annotations.services.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tools.jackson.databind.ObjectMapper;

import java.util.List;

@Service // Bu class'ı Spring Service Bean olarak yönetir.
@Lazy // Service'in oluşturulmasını ilk ihtiyaç anına erteler.
public class StudentServiceImpl implements IStudentService {

    @Autowired // StudentRepository Bean'ini Spring inject eder.
    private StudentRepository studentRepository;

    @Autowired // Spring, ObjectMapper Bean'ini buraya inject eder.
    private ObjectMapper objectMapper;

    @Override
    public DtoStudent save(DtoStudent dtoStudent) {
        // DTO'dan Entity oluşturuyoruz.
        Student student = new Student();

        // DTO bilgilerini Entity'ye aktarıyoruz.
        student.setFirstName(dtoStudent.getFirstName());
        student.setLastName(dtoStudent.getLastName());

        // Entity'yi database'e kaydediyoruz.
        Student savedStudent = studentRepository.save(student);

        // Burada tekrar Entity → DTO dönüşümü yapacağız.
        DtoStudent result = new DtoStudent();

        result.setFirstName(savedStudent.getFirstName());
        result.setLastName(savedStudent.getLastName());

        return result;
    }

    @Override
    public List<Student> findAll() {
        return studentRepository.findAll();// Database'deki tüm Student kayıtlarını getirir.
    }

    @Override
    public Student findById(Integer id) {
        return studentRepository.findById(id).get();
    }

    @Value("${student.message}") // application.properties içindeki değeri alır.
    private String studentMessage;

    @Transactional // Update işlemini transaction içinde yönetir.
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

    @Override
    public List<Student> findByFirstName(String firstName) {

        // Repository üzerinden firstName'e göre arama yapıyoruz.
        return studentRepository.findByFirstName(firstName);
    }


}