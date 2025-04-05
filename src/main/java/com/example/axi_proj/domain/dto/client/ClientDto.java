package com.example.axi_proj.domain.dto.client;

import com.example.axi_proj.domain.model.client.Education;
import com.example.axi_proj.domain.model.client.Gender;
import com.example.axi_proj.domain.model.client.MaritalStatus;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import java.time.LocalDate;


@Data
public class ClientDto {

    @Length(max = 64, message = "The first name must consist of at least 1 and no more than 64 characters")
    @NotBlank(message = "The first name must not be blank")
    @Pattern(regexp = "^[А-ЯЁ][а-яё]+(-[А-ЯЁ][а-яё]+)?$", message = "Incorrect first name")
    private String firstName;

    @Length(max = 64, message = "The second name must consist of at least 1 and no more than 64 characters")
    @NotBlank(message = "The second name must not be blank")
    @Pattern(regexp = "^[А-ЯЁ][а-яё]+(-[А-ЯЁ][а-яё]+)?$", message = "Incorrect second name")
    private String secondName;

    @Pattern(regexp = "^[А-ЯЁ][а-яё]+(-[А-ЯЁ][а-яё]+)?$", message = "Incorrect patronymic")
    private String patronymic;

    @Pattern(regexp = "^\\d{4}$", message = "Incorrect passport series")
    private String passportSeries;

    @Pattern(regexp = "^\\d{6}$", message = "Incorrect passport series")
    private String passportNumber;

    @Pattern(regexp = "^(\\+7|8|7)\\d{10}$", message = "Incorrect phone number")
    private String phone;

    @NotNull(message = "gender must not be blank")
    private Gender gender;

    @NotNull(message = "marital status must not be blank")
    private MaritalStatus maritalStatus;

    @NotBlank(message = "registration address must not be blank")
    private String registrationAddress;

    @NotBlank(message = "residential address must not be blank")
    private String residentialAddress;

    @NotBlank(message = "job must not be blank")
    private String job;

    @NotBlank(message = "job title must not be blank")
    private String jobTitle;

    @NotNull(message = "employment start must not be blank")
    private LocalDate employmentStart;

    @NotNull(message = "education must not be blank")
    private Education education;

}
