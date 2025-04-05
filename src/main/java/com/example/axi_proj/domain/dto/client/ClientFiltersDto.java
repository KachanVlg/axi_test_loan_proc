package com.example.axi_proj.domain.dto.client;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

@Data
public class ClientFiltersDto {

    @Length(max = 64, message = "The first name must consist of at least 1 and no more than 64 characters")
    @Pattern(regexp = "^[А-ЯЁ][а-яё]+(-[А-ЯЁ][а-яё]+)?$", message = "Incorrect first name")
    private String firstName;

    @Length(max = 64, message = "The second name must consist of at least 1 and no more than 64 characters")
    @Pattern(regexp = "^[А-ЯЁ][а-яё]+(-[А-ЯЁ][а-яё]+)?$", message = "Incorrect second name")
    private String secondName;

    @Pattern(regexp = "^[А-ЯЁ][а-яё]+(-[А-ЯЁ][а-яё]+)?$", message = "Incorrect patronymic")
    private String patronymic;

    @Pattern(regexp = "^\\d{4}$", message = "Incorrect passport series")
    private String passportSeries;

    @Pattern(regexp = "^\\d{6}$", message = "Incorrect passport series")
    private String passportNumber;
}



