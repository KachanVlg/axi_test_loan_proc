package com.example.axi_proj.domain.dto.client;


import lombok.Data;

@Data
public class ClientFiltrationRequestParams {
    private String firstName;
    private String secondName;
    private String patronymic;
    private String passportSeries;
    private String passportNumber;
}
