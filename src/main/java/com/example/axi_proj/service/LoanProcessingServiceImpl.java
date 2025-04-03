package com.example.axi_proj.service;


import com.example.axi_proj.domain.model.client.Client;
import com.example.axi_proj.domain.model.loanAgreement.LoanAgreement;
import com.example.axi_proj.domain.model.loanApplication.LoanApplication;
import org.springframework.stereotype.Service;


@Service
public class LoanProcessingServiceImpl implements LoanProcessingService{

    @Override
    public LoanApplication processApplication(LoanApplication loanApplication, Client client) {
        return null;
    }

    @Override
    public LoanAgreement signAgreement(long loanApplicationId) {
        return null;
    }
}
