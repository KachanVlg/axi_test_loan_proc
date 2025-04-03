package com.example.axi_proj.domain.model.loanApplication;


import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class LoanApplication {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 10, nullable = false)
    @Enumerated(EnumType.STRING)
    private LoanApplicationStatus status;

    @Column(nullable = false, precision = 9, scale = 2)
    private BigDecimal desiredAmount;

    @Column(nullable = false, precision = 9, scale = 2)
    private BigDecimal approvedAmount;

    @Column(nullable = false)
    private Integer approvedDeadline;
}
