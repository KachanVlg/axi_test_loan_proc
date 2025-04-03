package com.example.axi_proj.service;


import com.example.axi_proj.domain.model.loanAgreement.LoanAgreement;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoanAgreementServiceImpl implements LoanAgreementService{
    @Override
    public LoanAgreement save(LoanAgreement agreement) {
        return null;
    }

    @Override
    public List<LoanAgreement> listSignedAgreements(int page, int pageSize) {
        return List.of();
    }
}
