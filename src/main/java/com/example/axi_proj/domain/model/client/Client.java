package com.example.axi_proj.domain.model.client;


import com.example.axi_proj.domain.model.loanApplication.LoanApplication;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(uniqueConstraints = {@UniqueConstraint(columnNames = {"passportSeries", "passportNumber"})})
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 64, nullable = false)
    private String firstName;

    @Column(length = 64, nullable = false)
    private String secondName;

    @Column(length =64, nullable = false)
    private String patronymic;

    @Column(length = 4, nullable = false)
    private String passportSeries;

    @Column(length = 6, nullable = false)
    private String passportNumber;

    @Column(length = 6, nullable = false)
    @Enumerated(EnumType.STRING)
    private Gender gender;

    @Column(length = 7, nullable = false)
    @Enumerated(EnumType.STRING)
    private MaritalStatus maritalStatus;

    @Column(nullable = false)
    private String registrationAddress;

    @Column(nullable = false)
    private String residentialAddress;

    @Column(length = 16, nullable = false)
    private String phone;

    @Column(length = 20, nullable = false)
    @Enumerated(EnumType.STRING)
    private Education education;

    @Column(nullable = false)
    private String job;

    @Column(nullable = false)
    private String jobTitle;

    @Column(nullable = false)
    private LocalDate employmentStart;


    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "client_id")
    private List<LoanApplication> applications;


}
