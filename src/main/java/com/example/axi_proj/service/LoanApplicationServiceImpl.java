package com.example.axi_proj.service;


import com.example.axi_proj.domain.model.loanApplication.LoanApplication;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoanApplicationServiceImpl implements LoanApplicationService{
    @Override
    public LoanApplication save(LoanApplication application) {
        return null;
    }

    @Override
    public List<LoanApplication> listApproved(int page, int pageSize) {
        return List.of();
    }
}
