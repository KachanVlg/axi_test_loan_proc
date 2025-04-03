package com.example.axi_proj.repository;


import com.example.axi_proj.domain.model.loanAgreement.LoanAgreement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface LoanAgreementRepository extends JpaRepository<LoanAgreement, Long> {}
