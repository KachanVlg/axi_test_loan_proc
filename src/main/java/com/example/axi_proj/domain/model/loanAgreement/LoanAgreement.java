package com.example.axi_proj.domain.model.loanAgreement;


import com.example.axi_proj.domain.model.loanApplication.LoanApplication;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class LoanAgreement {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 10, nullable = false)
    @Enumerated(EnumType.STRING)
    private LoanAgreementStatus status;

    private LocalDate signDate;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "application_id")
    private LoanApplication application;

}
