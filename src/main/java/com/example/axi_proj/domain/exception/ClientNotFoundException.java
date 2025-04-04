package com.example.axi_proj.domain.exception;



public class ClientNotFoundException extends RuntimeException {

    private final static String MESSAGE = "Client with this passport was not found";

    public ClientNotFoundException() {
        super(MESSAGE);
    }
}
