package com.example.axi_proj.domain.dto.loan;

import com.example.axi_proj.domain.dto.client.ClientCreationDto;
import com.example.axi_proj.domain.model.loanApplication.LoanApplication;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.Data;


@Data
public class LoanApplicationAndClientCreationDto {

    @Valid
    @NotNull(message = "information about client is required")
    private ClientCreationDto client;

    @Valid
    @NotNull(message = "information about loan application is required")
    private LoanApplicationCreationDto loanApplication;
}
