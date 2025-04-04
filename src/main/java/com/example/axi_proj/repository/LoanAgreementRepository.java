package com.example.axi_proj.repository;


import com.example.axi_proj.domain.model.loanAgreement.LoanAgreement;
import com.example.axi_proj.domain.model.loanAgreement.LoanAgreementStatus;
import com.example.axi_proj.domain.model.loanApplication.LoanApplicationStatus;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface LoanAgreementRepository extends JpaRepository<LoanAgreement, Long> {

    List<LoanAgreement> findLoanAgreementByStatus(LoanAgreementStatus status, PageRequest pageRequest);
    Optional<LoanAgreement> findLoanAgreementByApplication_Id(Long application_id);
}
