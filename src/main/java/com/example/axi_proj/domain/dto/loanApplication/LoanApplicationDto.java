package com.example.axi_proj.domain.dto.loanApplication;


import com.example.axi_proj.domain.model.loanApplication.LoanApplicationStatus;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class LoanApplicationDto {

    private Long id;
    private LoanApplicationStatus status;
    private BigDecimal desiredAmount;
    private BigDecimal approvedAmount;
    private Integer approvedDeadline;
}
