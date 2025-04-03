package com.example.axi_proj.repository;


import com.example.axi_proj.domain.model.loanApplication.LoanApplication;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoanApplicationRepository extends JpaRepository<LoanApplication, Long> {}
