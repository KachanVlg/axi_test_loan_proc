package com.example.axi_proj.domain.dto.client;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

@Data
public class ClientFiltersDto {


    private String firstName;


    private String secondName;


    private String patronymic;


    private String passportSeries;


    private String passportNumber;
}



