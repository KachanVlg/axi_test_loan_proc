package com.example.axi_proj.service;


import com.example.axi_proj.domain.model.loanApplication.LoanApplication;
import com.example.axi_proj.domain.model.loanApplication.LoanApplicationStatus;
import com.example.axi_proj.repository.LoanApplicationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class LoanApplicationServiceImpl implements LoanApplicationService{

    private final LoanApplicationRepository repository;

    @Override
    public LoanApplication save(LoanApplication application) {
        return null;
    }

    @Override
    public List<LoanApplication> listApproved(int page, int pageSize) {
        return repository.findLoanApplicationsByStatus(LoanApplicationStatus.APPROVED);
    }
}
