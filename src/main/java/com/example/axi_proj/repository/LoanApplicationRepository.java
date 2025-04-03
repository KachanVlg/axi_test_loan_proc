package com.example.axi_proj.repository;


import com.example.axi_proj.domain.model.loanApplication.LoanApplication;
import com.example.axi_proj.domain.model.loanApplication.LoanApplicationStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LoanApplicationRepository extends JpaRepository<LoanApplication, Long> {

    List<LoanApplication> findLoanApplicationsByStatus(LoanApplicationStatus status);
}
