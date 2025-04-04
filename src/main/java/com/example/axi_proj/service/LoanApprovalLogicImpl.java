package com.example.axi_proj.service;


import com.example.axi_proj.domain.model.loanApplication.LoanApplication;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.Optional;
import java.util.Random;

@Component
public class LoanApprovalLogicImpl implements LoanApprovalLogic{

    private static final double APPROVAL_RATE = 0.6;


    @Override
    public Optional<LoanTerms> getLoanTerms(LoanApplication loanApplication) {

        if(!isApproved()) return Optional.empty();
        return Optional.of(composeLoanTerms(loanApplication));
    }

    private boolean isApproved() {
        Random random = new Random();
        return random.nextBoolean();
    }

    private LoanTerms composeLoanTerms(LoanApplication loanApplication) {

        BigDecimal approvedAmount = loanApplication.getDesiredAmount().multiply(BigDecimal.valueOf(APPROVAL_RATE));

        Random random = new Random();
        Integer approvedDeadline = random.nextInt(336) + 30;

        return new LoanTerms(approvedAmount, approvedDeadline);

    }
}
