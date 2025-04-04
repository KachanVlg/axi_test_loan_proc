package com.example.axi_proj.service;


import com.example.axi_proj.domain.dto.client.ClientFiltrationRequestParams;
import com.example.axi_proj.domain.model.client.Client;
import com.example.axi_proj.repository.ClientRepository;
import jakarta.persistence.criteria.Predicate;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class ClientServiceImpl implements ClientService{


    private final ClientRepository clientRepository;

    @Override
    public List<Client> list(ClientFiltrationRequestParams filter, int page, int pageSize) {

        String phone = filter.getPassportNumber();
        String firstName = filter.getFirstName();
        String secondName = filter.getSecondName();
        String patronymic = filter.getPatronymic();
        String passportSeries = filter.getPassportSeries();
        String passportNumber = filter.getPassportNumber();

        Specification<Client> desiredClient = (root, query, builder) -> {
            List<Predicate> predicates = new ArrayList<>();

            if (phone != null && !phone.isEmpty()) {
                predicates.add(builder.equal(root.get("phone"), phone));
            }

            if (firstName != null && !firstName.isEmpty()) {
                predicates.add(builder.equal(root.get("firstName"), firstName));
            }

            if (secondName != null && !secondName.isEmpty()) {
                predicates.add(builder.equal(root.get("secondName"), secondName));
            }

            if (patronymic != null && !patronymic.isEmpty()) {
                predicates.add(builder.equal(root.get("patronymic"), patronymic));
            }

            if (passportSeries != null && !passportSeries.isEmpty()) {
                predicates.add(builder.equal(root.get("passportSeries"), passportSeries));
            }

            if (passportNumber != null && !passportNumber.isEmpty()) {
                predicates.add(builder.equal(root.get("passportNumber"), passportNumber));
            }
            return builder.and(predicates.toArray(new Predicate[0]));
        };
        return clientRepository.findAll(desiredClient, PageRequest.of(page, pageSize)).toList();
    }


    @Override
    public Client save(Client client) {
        return null;
    }

    @Override
    public Optional<Client> get(String passwordSeries, String passportNumber) {
        return clientRepository.findClientByPassportNumberAndPassportSeries(passportNumber, passwordSeries);
    }

}
