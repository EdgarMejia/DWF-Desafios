package com.letrasvivas.book_api.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class BookCreateDTO {

    @NotBlank(message = "El título no puede estar vacío.")
    @Size(max = 255, message = "El título debe tener menos de 255 caracteres.")
    private String title;

    @NotBlank(message = "El autor no puede estar vacío.")
    private String author;

    private String isbn;
}