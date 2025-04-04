package com.example.axi_proj.service;


import com.example.axi_proj.domain.dto.client.ClientFiltersDto;
import com.example.axi_proj.domain.model.client.Client;

import java.util.List;
import java.util.Optional;

public interface ClientService {
    List<Client> list(ClientFiltersDto filter, int page, int pageSize);
    Client save(Client client);
    Client getByPassport(String passportSeries, String passportNumber);
}
