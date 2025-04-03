package com.example.axi_proj.controller;


import com.example.axi_proj.domain.dto.client.ClientFiltrationRequestParams;
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
    public List<ClientFiltrationRequestParams> list(@RequestParam  ClientFiltrationRequestParams params){

    }





}
