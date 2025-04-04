package com.example.axi_proj.service;


import com.example.axi_proj.domain.model.loanAgreement.LoanAgreement;
import com.example.axi_proj.domain.model.loanApplication.LoanApplication;

import java.util.List;

public interface LoanAgreementService {

    LoanAgreement save(LoanAgreement agreement);
    List<LoanAgreement> listSignedAgreements(int page, int pageSize);
    LoanAgreement getByApplication(long applicationId);
}
