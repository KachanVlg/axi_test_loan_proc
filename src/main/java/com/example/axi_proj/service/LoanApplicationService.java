package com.example.axi_proj.service;


import com.example.axi_proj.domain.model.loanApplication.LoanApplication;

import java.util.List;

public interface LoanApplicationService {
    LoanApplication save(LoanApplication application);
    List<LoanApplication> listApproved(int page, int pageSize);
}
