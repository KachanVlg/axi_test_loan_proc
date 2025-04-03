package com.example.axi_proj.domain.dto.loan;


import com.example.axi_proj.domain.model.loanApplication.LoanApplicationStatus;
import jakarta.persistence.*;
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
