package com.example.axi_proj.service;


import com.example.axi_proj.domain.exception.ClientNotFoundException;
import com.example.axi_proj.domain.exception.LoanAgreementNotFoundException;
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

import java.time.LocalDate;
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

        Client persistedClient;
        LoanApplication persistedLoanApplication;

        //Проверяем на уже существующего клиента
        try {

            persistedClient = clientService.getByPassport(client.getPassportSeries(), client.getPassportNumber());

            if(!persistedClient.equals(client)) {

                List<FieldError> errors = List.of(new FieldError(
                        "client",
                        "",
                        "Client data mismatch"
                ));
                throw new ValidationException(errors);
            }

        } catch(ClientNotFoundException e) {

            persistedClient = clientService.save(client);

        }

        //Сохраняем заявку
        loanApplication.setClient(persistedClient);
        loanApplication.setStatus(LoanApplicationStatus.PROCESSING);
        persistedLoanApplication = loanApplicationService.save(loanApplication);

        //Узнаем, одобрен ли кредит
        Optional<LoanTerms> loanTermsOptional = loanApprovalLogic.getLoanTerms(loanApplication);

        //Если кредит не одобрен
        if(loanTermsOptional.isEmpty()) {

            //Сохраняем заявку со статусом "отклонена"
            persistedLoanApplication.setStatus(LoanApplicationStatus.REJECTED);
            return loanApplicationService.save(persistedLoanApplication);
        }

        //Если кредит одобрен, заполняем условия заявления.
        //Сохраняем заявку
        persistedLoanApplication.setStatus(LoanApplicationStatus.APPROVED);
        persistedLoanApplication.setApprovedAmount(loanTermsOptional.get().getApprovedAmount());
        persistedLoanApplication.setApprovedDeadline(loanTermsOptional.get().getApprovedDeadline());
        persistedLoanApplication = loanApplicationService.save(persistedLoanApplication);


        //Создаем кредитный договор
        LoanAgreement loanAgreement = new LoanAgreement();
        loanAgreement.setApplication(persistedLoanApplication);
        loanAgreement.setStatus(LoanAgreementStatus.NOT_SIGNED);
        loanAgreementService.save(loanAgreement);

        return persistedLoanApplication;
    }


    @Override
    public LoanAgreement signAgreement(long loanApplicationId) {

        LoanAgreement persistedLoanAgreement;

        try {
            persistedLoanAgreement = loanAgreementService.getByApplication(loanApplicationId);
        } catch (LoanAgreementNotFoundException e) {
            List<FieldError> errors = List.of(new FieldError(
                    "agreement",
                    "",
                    "Agreement is not found"
            ));
            throw new ValidationException(errors);
        }

        persistedLoanAgreement.setStatus(LoanAgreementStatus.SIGNED);
        persistedLoanAgreement.setSignDate(LocalDate.now());

        return loanAgreementService.save(persistedLoanAgreement);
    }
}
