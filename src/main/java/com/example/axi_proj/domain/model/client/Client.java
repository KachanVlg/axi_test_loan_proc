package com.example.axi_proj.domain.model.client;


import com.example.axi_proj.domain.model.loanApplication.LoanApplication;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

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

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Gender gender;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private MaritalStatus maritalStatus;

    @Column(nullable = false)
    private String registrationAddress;

    @Column(nullable = false)
    private String residentialAddress;

    @Column(length = 16, nullable = false)
    private String phone;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Education education;

    @Column(nullable = false)
    private String job;

    @Column(nullable = false)
    private String jobTitle;

    @Column(nullable = false)
    private LocalDate employmentStart;

    @OneToMany(mappedBy = "client", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<LoanApplication> applications;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Client client = (Client) o;
        return Objects.equals(firstName, client.firstName) &&
                Objects.equals(secondName, client.secondName) &&
                Objects.equals(patronymic, client.patronymic) &&
                Objects.equals(passportSeries, client.passportSeries) &&
                Objects.equals(passportNumber, client.passportNumber) &&
                gender == client.gender &&
                maritalStatus == client.maritalStatus &&
                Objects.equals(registrationAddress, client.registrationAddress) &&
                Objects.equals(residentialAddress, client.residentialAddress) &&
                Objects.equals(phone, client.phone) &&
                education == client.education &&
                Objects.equals(job, client.job) &&
                Objects.equals(jobTitle, client.jobTitle) &&
                Objects.equals(employmentStart, client.employmentStart);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, secondName, patronymic, passportSeries, passportNumber,
                gender, maritalStatus, registrationAddress, residentialAddress, phone,
                education, job, jobTitle, employmentStart);
    }
}
