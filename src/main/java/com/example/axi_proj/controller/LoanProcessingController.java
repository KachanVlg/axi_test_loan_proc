package com.example.axi_proj.controller;
import com.example.axi_proj.domain.dto.client.ClientDto;
import com.example.axi_proj.domain.dto.loanAgreement.LoanAgreementDto;
import com.example.axi_proj.domain.dto.loanApplication.LoanApplicationAndClientCreationDto;
import com.example.axi_proj.domain.dto.loanApplication.LoanApplicationCreationDto;
import com.example.axi_proj.domain.dto.loanApplication.LoanApplicationDto;
import com.example.axi_proj.domain.model.client.Client;
import com.example.axi_proj.domain.model.loanAgreement.LoanAgreement;
import com.example.axi_proj.domain.model.loanApplication.LoanApplication;
import com.example.axi_proj.service.LoanProcessingService;
import com.example.axi_proj.util.DtoMapper;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/loan_processing")
@RequiredArgsConstructor
@Validated
public class LoanProcessingController {

    private final LoanProcessingService loanProcessingService;
    private final DtoMapper dtoMapper;
    private final static String SIGN_AGREEMENT = "/signing/{loanApplicationId}";

    @PostMapping
    public LoanApplicationDto create(@Valid @RequestBody LoanApplicationAndClientCreationDto dto) {

        //Получение вложенных dto
        LoanApplicationCreationDto loanApplicationCreationDto = dto.getLoanApplication();
        ClientDto clientDto = dto.getClient();

        //Маппинг в модели
        LoanApplication loanApplicationModel = dtoMapper.toModel(loanApplicationCreationDto, LoanApplication.class);
        Client clientModel = dtoMapper.toModel(clientDto, Client.class);

        //Принять заявку на обработку
        LoanApplication newLoanApplicationModel = loanProcessingService.processApplication(loanApplicationModel, clientModel);

        //Маппинг ответа сервиса
        return dtoMapper.toDto(newLoanApplicationModel, LoanApplicationDto.class);

    }


    @PutMapping(SIGN_AGREEMENT)
    public LoanAgreementDto sign(@PathVariable long loanApplicationId) {

        //Подписать договор
        LoanAgreement loanAgreement = loanProcessingService.signAgreement(loanApplicationId);

        //Маппинг ответа сервиса
        return dtoMapper.toDto(loanAgreement, LoanAgreementDto.class);

    }

}
