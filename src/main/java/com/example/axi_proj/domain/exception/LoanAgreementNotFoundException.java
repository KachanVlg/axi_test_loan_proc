package com.example.axi_proj.domain.exception;




public class LoanAgreementNotFoundException extends RuntimeException {

    private final static String MESSAGE = "Loan agreement with this application id was not found";

    public LoanAgreementNotFoundException() {
        super(MESSAGE);
    }
}
