package com.example.axi_proj.repository;

import com.example.axi_proj.domain.model.client.Client;
import com.example.axi_proj.domain.model.client.Education;
import com.example.axi_proj.domain.model.client.Gender;
import com.example.axi_proj.domain.model.client.MaritalStatus;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
@RequiredArgsConstructor
public class DataSeeder implements CommandLineRunner {

    private final ClientRepository clientRepository;

    @Override
    public void run(String... args) throws Exception {

        clientRepository.deleteAll();


        Client client1 = new Client();
        client1.setFirstName("Иван");
        client1.setSecondName("Иванов");
        client1.setPatronymic("Иванович");
        client1.setPassportSeries("22");
        client1.setPassportNumber("123456");
        client1.setGender(Gender.MALE);
        client1.setMaritalStatus(MaritalStatus.MARRIED);
        client1.setRegistrationAddress("Москва, ул. Ленина, 1");
        client1.setResidentialAddress("Москва, ул. Тверская, 2");
        client1.setPhone("89011234567");
        client1.setEducation(Education.HIGHER);
        client1.setJob("Разработчик");
        client1.setJobTitle("Software Engineer");
        client1.setEmploymentStart(LocalDate.of(2020, 1, 1));

        Client client2 = new Client();
        client2.setFirstName("Мария");
        client2.setSecondName("Петрова");
        client2.setPatronymic("Алексеевна");
        client2.setPassportSeries("33");
        client2.setPassportNumber("654321");
        client2.setGender(Gender.FEMALE);
        client2.setMaritalStatus(MaritalStatus.SINGLE);
        client2.setRegistrationAddress("Санкт-Петербург, ул. Невский пр., 15");
        client2.setResidentialAddress("Санкт-Петербург, ул. Восстания, 3");
        client2.setPhone("89012345678");
        client2.setEducation(Education.SECONDARY_GENERAL);
        client2.setJob("Менеджер");
        client2.setJobTitle("Project Manager");
        client2.setEmploymentStart(LocalDate.of(2018, 6, 15));

        clientRepository.save(client1);
        clientRepository.save(client2);
    }
}
