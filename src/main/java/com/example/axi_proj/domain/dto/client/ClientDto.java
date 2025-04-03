package com.example.axi_proj.domain.dto.client;

import com.example.axi_proj.domain.model.client.Education;
import com.example.axi_proj.domain.model.client.Gender;
import com.example.axi_proj.domain.model.client.MaritalStatus;
import lombok.Data;

import java.time.LocalDate;

@Data
public class ClientDto {

    private String firstName;
    private String secondName;
    private String patronymic;
    private String passportSeries;
    private String passportNumber;
    private Gender gender;
    private MaritalStatus maritalStatus;
    private String registrationAddress;
    private String residentialAddress;
    private String phone;
    private Education education;
    private String job;
    private String jobTitle;
    private LocalDate employmentStart;
}
