package com.example.axi_proj.controller;

import com.example.axi_proj.domain.dto.exception.ValidationErrorDto;
import com.example.axi_proj.domain.exception.ValidationException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ApiControllerAdvice {

    @ExceptionHandler
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ValidationErrorDto handleValidationException(ValidationException e){
        return new ValidationErrorDto(e.getFieldErrors());
    }

}
