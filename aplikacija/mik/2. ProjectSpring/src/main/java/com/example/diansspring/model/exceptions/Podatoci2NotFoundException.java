package com.example.diansspring.model.exceptions;

public class Podatoci2NotFoundException extends RuntimeException {
    public Podatoci2NotFoundException(Long id) {
        super(String.format("Podatoci2 was not found with this id: %ld",id));
    }
}
