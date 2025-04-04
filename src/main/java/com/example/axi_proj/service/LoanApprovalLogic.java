package com.example.axi_proj.service;


import com.example.axi_proj.domain.model.loanApplication.LoanApplication;
import org.springframework.stereotype.Component;

import java.util.Optional;


public interface LoanApprovalLogic {
    Optional<LoanTerms> getLoanTerms(LoanApplication loanApplication);
}
