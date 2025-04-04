package com.example.axi_proj.service;


import com.example.axi_proj.domain.exception.ValidationException;
import com.example.axi_proj.domain.model.client.Client;
import com.example.axi_proj.domain.model.loanAgreement.LoanAgreement;
import com.example.axi_proj.domain.model.loanAgreement.LoanAgreementStatus;
import com.example.axi_proj.domain.model.loanApplication.LoanApplication;
import com.example.axi_proj.domain.model.loanApplication.LoanApplicationStatus;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.FieldError;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
@RequiredArgsConstructor
public class LoanProcessingServiceImpl implements LoanProcessingService{


    private final LoanApplicationService loanApplicationService;
    private final LoanAgreementService loanAgreementService;
    private final ClientService clientService;
    private final LoanApprovalLogic loanApprovalLogic;



    @Override
    @Transactional
    public LoanApplication processApplication(LoanApplication loanApplication, Client client) {


        Optional<Client> optionalClient = clientService.get(client.getPassportSeries(), client.getPassportNumber());
        LoanApplication savedLoanApplication;
        Client savedClient;
        if(optionalClient.isPresent()) {

            if(!optionalClient.get().equals(client)) {

                List<FieldError> errors = List.of(new FieldError(
                        "client",
                        "",
                        "Client data mismatch"
                ));
                throw new ValidationException(errors);
            }

            loanApplication.setClient(optionalClient.get());

        } else {
            savedClient = clientService.save(client);
            loanApplication.setClient(savedClient);
        }

        loanApplication.setStatus(LoanApplicationStatus.PROCESSING);
        savedLoanApplication = loanApplicationService.save(loanApplication);

        Optional<LoanTerms> loanTermsOptional = loanApprovalLogic.getLoanTerms(loanApplication);

        if(loanTermsOptional.isEmpty()) {

            loanApplication.setStatus(LoanApplicationStatus.REJECTED);
            return loanApplicationService.save(loanApplication);
        }

        LoanAgreement loanAgreement = new LoanAgreement();
        loanAgreement.setApplication(loanApplication);
        loanAgreement.setStatus(LoanAgreementStatus.NOT_SIGNED);
        loanAgreementService.save(loanAgreement);

        return loanApplication;
    }

    @Override
    public LoanAgreement signAgreement(long loanApplicationId) {
        return null;
    }
}
