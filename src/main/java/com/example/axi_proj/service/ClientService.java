package com.example.axi_proj.service;


import com.example.axi_proj.domain.dto.client.ClientFiltrationRequestParams;
import com.example.axi_proj.domain.model.client.Client;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface ClientService {
    List<Client> list(ClientFiltrationRequestParams filter, int page, int pageSize);
    List<Client> findBy(String phone,
                     String firstName,
                     String secondName,
                     String patronymic,
                     String passportSeries,
                     String passportNumber,
                     int page,
                     int pageSize);
    Client save(Client client);
    boolean exists(String passwordSeries, String passportNumber);
    Client get(String passwordSeries, String passportNumber);

}
