package com.fatihsahin.annotations;

import com.fatihsahin.annotations.dto.DtoStudent;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.JsonTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.test.context.TestPropertySource;


import static org.assertj.core.api.Assertions.assertThat;

@JsonTest // Sadece JSON dönüşümlerini test eder.
@TestPropertySource(
        properties = "student.message=Test mesajı" // Sadece bu testte bu değeri kullan.
)
class DtoStudentJsonTest {

    @Autowired
    private JacksonTester<DtoStudent> json; // DTO'yu JSON'a çevirip tekrar okuyabiliriz.

    @Test
    void student_shouldSerializeToJson() throws Exception {

        // Test için Student DTO oluşturuyoruz.
        DtoStudent student = new DtoStudent(
                "Fatih",
                "Şahin"
        );

        // Java nesnesini JSON'a çeviriyoruz.
        String jsonContent = json.write(student)
                .getJson();

        // JSON içinde firstName olduğunu kontrol ediyoruz.
        assertThat(jsonContent)
                .contains("\"firstName\":\"Fatih\"");

        // JSON içinde lastName olduğunu kontrol ediyoruz.
        assertThat(jsonContent)
                .contains("\"lastName\":\"Şahin\"");
    }
}