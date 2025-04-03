package com.example.axi_proj.controller;

import com.example.axi_proj.domain.dto.loan.LoanAgreementDto;
import com.example.axi_proj.domain.dto.loan.LoanApplicationDto;
import com.example.axi_proj.domain.model.loanAgreement.LoanAgreement;
import com.example.axi_proj.domain.model.loanApplication.LoanApplication;
import com.example.axi_proj.service.LoanAgreementService;
import com.example.axi_proj.service.LoanApplicationService;
import com.example.axi_proj.util.DtoMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/applications")
@RequiredArgsConstructor
public class LoanApplicationController {

    private final DtoMapper dtoMapper;
    private final LoanApplicationService loanApplicationService;

    @GetMapping
    public List<LoanApplicationDto> listApprovedApplications(@RequestParam(required = false, defaultValue = "0") int page,
                                                           @RequestParam(required = false, defaultValue = "1") int pageSize) {

        List<LoanApplication> applicationModels = loanApplicationService.listApproved(page, pageSize);
        return dtoMapper.toDto(applicationModels, LoanApplicationDto.class);
    }
}