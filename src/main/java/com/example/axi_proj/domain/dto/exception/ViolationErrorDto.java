package com.example.axi_proj.domain.dto.exception;


import jakarta.validation.ConstraintViolation;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;


@Data
@AllArgsConstructor
public class ViolationErrorDto {

    private final List<String> errors;

    public ViolationErrorDto(Set<ConstraintViolation<?>> violations) {
        this.errors = violations.stream()
                .map(ConstraintViolation::getMessage)
                .collect(Collectors.toList());
    }
}
