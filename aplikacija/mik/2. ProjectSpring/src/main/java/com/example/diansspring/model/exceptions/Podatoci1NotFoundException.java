package com.example.diansspring.model.exceptions;

public class Podatoci1NotFoundException extends RuntimeException{
    public Podatoci1NotFoundException(Long id) {
        super(String.format("Podatoci1 was not found with this id: %ld",id));
    }
}
