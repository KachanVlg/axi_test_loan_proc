package com.example.axi_proj.domain.dto.loan;


import com.example.axi_proj.domain.model.loanApplication.LoanApplicationStatus;
import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class LoanApplicationCreationResponseDto {


    private Long id;
    private LoanApplicationStatus status;
    private BigDecimal desiredAmount;
    private BigDecimal approvedAmount;
    private Integer approvedDeadline;
}
