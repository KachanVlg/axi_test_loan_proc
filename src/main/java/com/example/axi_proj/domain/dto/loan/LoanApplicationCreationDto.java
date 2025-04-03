package com.example.axi_proj.domain.dto.loan;


import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class LoanApplicationCreationDto {

    @NotNull(message = "Desired amount must not be blank")
    @Digits(integer = 7, fraction = 2, message = "The loan amount must be kept to no more than 7 digits before the decimal point and 2 after it")
    private BigDecimal desiredAmount;
}
