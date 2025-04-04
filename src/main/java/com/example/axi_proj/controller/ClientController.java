package com.example.axi_proj.controller;


import com.example.axi_proj.domain.dto.client.ClientDto;
import com.example.axi_proj.domain.dto.client.ClientFiltersDto;
import com.example.axi_proj.domain.model.client.Client;
import com.example.axi_proj.service.ClientService;
import com.example.axi_proj.util.DtoMapper;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/clients")
@RequiredArgsConstructor
@Validated
public class ClientController {

    private final ClientService clientService;
    private final DtoMapper dtoMapper;

    @GetMapping
    public List<ClientDto> list(@RequestParam(required = false, defaultValue = "0") int page,
                                @RequestParam(required = false, defaultValue = "10") int pageSize,
                                @ModelAttribute @Valid ClientFiltersDto filters) {

        //Получить клиентов по фильтрам
        List<Client> clientModels = clientService.list(filters, page, pageSize);

        //Маппинг в дто
        return dtoMapper.toDto(clientModels, ClientDto.class);

    }

}
