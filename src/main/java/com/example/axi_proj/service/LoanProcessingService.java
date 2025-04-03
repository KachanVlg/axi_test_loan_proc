package com.example.axi_proj.service;


import com.example.axi_proj.domain.model.client.Client;
import com.example.axi_proj.domain.model.loanAgreement.LoanAgreement;
import com.example.axi_proj.domain.model.loanApplication.LoanApplication;

public interface LoanProcessingService {


    LoanApplication processApplication(LoanApplication loanApplication, Client client);
    LoanAgreement signAgreement(long loanApplicationId);
}
