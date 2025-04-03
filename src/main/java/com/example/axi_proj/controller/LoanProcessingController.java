package com.example.axi_proj.controller;


import com.example.axi_proj.domain.dto.client.ClientCreationDto;
import com.example.axi_proj.domain.dto.loan.LoanAgreementResponseDto;
import com.example.axi_proj.domain.dto.loan.LoanApplicationAndClientCreationDto;
import com.example.axi_proj.domain.dto.loan.LoanApplicationCreationDto;
import com.example.axi_proj.domain.dto.loan.LoanApplicationCreationResponseDto;
import com.example.axi_proj.domain.exception.ValidationException;
import com.example.axi_proj.domain.model.client.Client;
import com.example.axi_proj.domain.model.loanAgreement.LoanAgreement;
import com.example.axi_proj.domain.model.loanApplication.LoanApplication;
import com.example.axi_proj.service.LoanProcessingService;
import com.example.axi_proj.util.DtoMapper;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/loan_processing")
@RequiredArgsConstructor
@Validated
public class LoanProcessingController {

    private final LoanProcessingService loanProcessingService;
    private final DtoMapper dtoMapper;

    @PostMapping
    public LoanApplicationCreationResponseDto create(@Valid @RequestBody LoanApplicationAndClientCreationDto dto,
                                                         BindingResult bindingResult) {
        if(bindingResult.hasErrors()){
            throw new ValidationException(bindingResult.getFieldErrors());
        }

        LoanApplicationCreationDto loanApplicationCreationDto = dto.getLoanApplication();
        ClientCreationDto clientCreationDto = dto.getClient();

        LoanApplication loanApplicationModel = dtoMapper.toModel(loanApplicationCreationDto, LoanApplication.class);
        Client clientModel = dtoMapper.toModel(clientCreationDto, Client.class);

        LoanApplication newLoanApplicationModel = loanProcessingService.processApplication(loanApplicationModel, clientModel);

        return dtoMapper.toDto(newLoanApplicationModel, LoanApplicationCreationResponseDto.class);
    }

    @PutMapping("/signing/{loanApplicationId}")
    public LoanAgreementResponseDto sign(@PathVariable long loanApplicationId) {

        LoanAgreement loanAgreement = loanProcessingService.signAgreement(loanApplicationId);
        return dtoMapper.toDto(loanAgreement, LoanAgreementResponseDto.class);
    }

}
