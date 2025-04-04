package com.example.axi_proj.controller;


import com.example.axi_proj.domain.dto.loan.LoanAgreementDto;
import com.example.axi_proj.domain.model.loanAgreement.LoanAgreement;
import com.example.axi_proj.service.LoanAgreementService;
import com.example.axi_proj.util.DtoMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/agreements")
@RequiredArgsConstructor
public class LoanAgreementController {

    private final DtoMapper dtoMapper;
    private final LoanAgreementService loanAgreementService;

    @GetMapping
    public List<LoanAgreementDto> listApprovedAgreements(@RequestParam(required = false, defaultValue = "0") int page,
                                                         @RequestParam(required = false, defaultValue = "10") int pageSize) {

        List<LoanAgreement> agreementModels = loanAgreementService.listSignedAgreements(page, pageSize);
        return dtoMapper.toDto(agreementModels, LoanAgreementDto.class);
    }
}
