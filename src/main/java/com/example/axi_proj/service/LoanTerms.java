package com.example.axi_proj.service;


import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
public class LoanTerms {

    private BigDecimal approvedAmount;
    private Integer approvedDeadline;
}
