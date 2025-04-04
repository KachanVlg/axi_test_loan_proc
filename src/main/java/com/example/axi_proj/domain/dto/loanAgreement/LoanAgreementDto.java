package com.example.axi_proj.domain.dto.loanAgreement;
import com.example.axi_proj.domain.model.loanAgreement.LoanAgreementStatus;
import lombok.Data;

import java.time.LocalDate;


@Data
public class LoanAgreementDto {

    private Long id;
    private LoanAgreementStatus status;
    private LocalDate signDate;
}
