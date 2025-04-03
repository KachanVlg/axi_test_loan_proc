package com.example.axi_proj.controller;


import com.example.axi_proj.domain.dto.client.ClientFiltrationRequestParams;
import com.example.axi_proj.domain.dto.client.ClientDto;
import com.example.axi_proj.domain.model.client.Client;
import com.example.axi_proj.service.ClientService;
import com.example.axi_proj.util.DtoMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/clients")
@RequiredArgsConstructor
public class ClientController {

    private final ClientService clientService;

    private final DtoMapper dtoMapper;

    @GetMapping
    public List<ClientDto> list(@RequestParam(required = false, defaultValue = "0") int page,
                                @RequestParam(required = false, defaultValue = "1") int pageSize,
                                @RequestParam ClientFiltrationRequestParams filter) {

        List<Client> clientModels = clientService.list(filter, page, pageSize);
        return dtoMapper.toDto(clientModels, ClientDto.class);
    }
}
