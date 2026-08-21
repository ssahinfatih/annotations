package com.fatihsahin.annotations;

import com.fatihsahin.annotations.controller.impl.StudentControllerImpl;
import com.fatihsahin.annotations.entities.Student;
import com.fatihsahin.annotations.services.IStudentService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.webmvc.test.autoconfigure.AutoConfigureMockMvc;
import org.springframework.boot.webmvc.test.autoconfigure.WebMvcTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(StudentControllerImpl.class) // Sadece StudentController'ı test eder.
@AutoConfigureMockMvc(addFilters = false) // Bu testte Security filtrelerini kapatır.
class StudentControllerTest {

    @Autowired
    private MockMvc mockMvc; // Controller'a sahte HTTP isteği göndermemizi sağlar.

    @MockitoBean
    private IStudentService studentService; // Gerçek Service yerine mock kullanıyoruz.

    @Test
    void findAll_shouldReturn200() throws Exception {

        // Service'in iki öğrenci döndürmesini söylüyoruz.
        given(studentService.findAll())
                .willReturn(List.of(
                        new Student(1, "Fatih", "Şahin"),
                        new Student(2, "Ahmet", "Yılmaz")
                ));

        // GET /students/list isteğini gönderiyoruz.
        mockMvc.perform(
                        get("/students/list")
                )
                // Controller'ın 200 OK döndürmesini bekliyoruz.
                .andExpect(status().isOk());
    }
}