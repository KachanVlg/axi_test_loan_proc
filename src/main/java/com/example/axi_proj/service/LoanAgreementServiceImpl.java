package com.example.axi_proj.service;


import com.example.axi_proj.domain.exception.LoanAgreementNotFoundException;
import com.example.axi_proj.domain.model.loanAgreement.LoanAgreement;
import com.example.axi_proj.domain.model.loanAgreement.LoanAgreementStatus;
import com.example.axi_proj.domain.model.loanApplication.LoanApplication;
import com.example.axi_proj.domain.model.loanApplication.LoanApplicationStatus;
import com.example.axi_proj.repository.LoanAgreementRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class LoanAgreementServiceImpl implements LoanAgreementService{

    private final LoanAgreementRepository repository;

    @Override
    public LoanAgreement save(LoanAgreement agreement) {
        return repository.save(agreement);
    }

    @Override
    public List<LoanAgreement> listSignedAgreements(int page, int pageSize) {
        return repository.findLoanAgreementByStatus(LoanAgreementStatus.SIGNED, PageRequest.of(page, pageSize));
    }

    @Override
    public LoanAgreement getByApplication(long applicationId) {

        Optional<LoanAgreement> optionalLoanAgreement = repository.findLoanAgreementByApplication_Id(applicationId);

        if(optionalLoanAgreement.isEmpty()) throw new LoanAgreementNotFoundException();

        return optionalLoanAgreement.get();
    }
}
