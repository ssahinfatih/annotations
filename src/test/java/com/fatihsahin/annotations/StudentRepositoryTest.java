package com.fatihsahin.annotations;

import com.fatihsahin.annotations.entities.Student;
import com.fatihsahin.annotations.repository.StudentRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.data.jpa.test.autoconfigure.DataJpaTest;
import org.springframework.boot.jdbc.test.autoconfigure.AutoConfigureTestDatabase;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest // Sadece JPA ve Repository tarafını test eder.
@AutoConfigureTestDatabase(
        replace = AutoConfigureTestDatabase.Replace.NONE // PostgreSQL DataSource'umuzu değiştirme.
)
class StudentRepositoryTest {

    @Autowired
    private StudentRepository studentRepository; // Gerçek Repository Bean'ini alıyoruz.

    @Test
    void findAll_shouldReturnStudents() {

        // Database'deki bütün Student kayıtlarını getiriyoruz.
        List<Student> students = studentRepository.findAll();

        // Listenin null olmamasını bekliyoruz.
        assertThat(students).isNotNull();
    }
    @Test
    void saveAndFindById_shouldWork() {

        // Yeni Student oluşturuyoruz.
        Student student = new Student();

        // Öğrencinin adını veriyoruz.
        student.setFirstName("Fatih");

        // Öğrencinin soyadını veriyoruz.
        student.setLastName("Şahin");

        // Database'e kaydediyoruz.
        Student savedStudent = studentRepository.save(student);

        // Kaydedilen Student'ın ID'si oluşmuş olmalı.
        assertThat(savedStudent.getId()).isNotNull();

        // ID ile tekrar database'den getiriyoruz.
        Student foundStudent = studentRepository
                .findById(savedStudent.getId())
                .orElse(null);

        // Student'ın gerçekten bulunduğunu kontrol ediyoruz.
        assertThat(foundStudent).isNotNull();

        // FirstName'in doğru kaydedildiğini kontrol ediyoruz.
        assertThat(foundStudent.getFirstName())
                .isEqualTo("Fatih");
    }
}