package com.example.axi_proj.service;


import com.example.axi_proj.domain.model.loanApplication.LoanApplication;
import com.example.axi_proj.domain.model.loanApplication.LoanApplicationStatus;
import com.example.axi_proj.repository.LoanApplicationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
@RequiredArgsConstructor
public class LoanApplicationServiceImpl implements LoanApplicationService{

    private final LoanApplicationRepository repository;

    @Override
    public LoanApplication save(LoanApplication application) {
        return repository.save(application);
    }

    @Override
    public List<LoanApplication> listApproved(int page, int pageSize) {
        return repository.findLoanApplicationsByStatus(LoanApplicationStatus.APPROVED, PageRequest.of(page, pageSize));
    }

    @Override
    public LoanApplication get(long id) {
        return repository.getReferenceById(id);
    }
}
