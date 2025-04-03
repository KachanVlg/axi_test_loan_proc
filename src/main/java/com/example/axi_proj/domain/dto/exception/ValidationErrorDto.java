package com.example.axi_proj.domain.dto.exception;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;
import java.util.Map;

@Data
@AllArgsConstructor
public class ValidationErrorDto {
    private Map<String, List<String>> fieldErrors;
}
