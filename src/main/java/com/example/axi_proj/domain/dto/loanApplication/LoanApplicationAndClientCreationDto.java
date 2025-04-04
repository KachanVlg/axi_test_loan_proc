package com.example.axi_proj.domain.dto.loanApplication;

import com.example.axi_proj.domain.dto.client.ClientDto;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.Data;


@Data
public class LoanApplicationAndClientCreationDto {

    @Valid
    @NotNull(message = "information about client is required")
    private ClientDto client;

    @Valid
    @NotNull(message = "information about loan application is required")
    private LoanApplicationCreationDto loanApplication;
}
