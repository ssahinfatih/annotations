package com.fatihsahin.annotations.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DtoStudent {

    @NotBlank // firstName boş, null veya sadece boşluk olamaz.
    @Size(min = 2, max = 50) // firstName 2-50 karakter arasında olmalı.
    private String firstName;

    @NotBlank // lastName boş, null veya sadece boşluk olamaz.
    @Size(min = 2, max = 50) // lastName 2-50 karakter arasında olmalı.
    private String lastName;

}
