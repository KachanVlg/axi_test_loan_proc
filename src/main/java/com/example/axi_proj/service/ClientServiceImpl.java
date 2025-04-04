package com.example.axi_proj.service;


import com.example.axi_proj.domain.dto.client.ClientFiltersDto;
import com.example.axi_proj.domain.exception.ClientNotFoundException;
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
@RequiredArgsConstructor
public class ClientServiceImpl implements ClientService{


    private final ClientRepository clientRepository;

    @Override
    public List<Client> list(ClientFiltersDto filters, int page, int pageSize) {


        if(filters == null) {
            return clientRepository.findAll(PageRequest.of(page, pageSize)).toList();
        }

        String phone = filters.getPassportNumber();
        String firstName = filters.getFirstName();
        String secondName = filters.getSecondName();
        String patronymic = filters.getPatronymic();
        String passportSeries = filters.getPassportSeries();
        String passportNumber = filters.getPassportNumber();

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

        return clientRepository.save(client);

    }

    @Override
    public Client getByPassport(String passportSeries, String passportNumber) {

        Optional<Client> optionalClient = clientRepository.findClientByPassportNumberAndPassportSeries(passportNumber, passportSeries);

        if(optionalClient.isEmpty()) throw new ClientNotFoundException();

        return optionalClient.get();
    }

}
