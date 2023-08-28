package com.example.diansspring.model.exceptions;

public class PodatociNotFoundException extends RuntimeException{
    public PodatociNotFoundException(Long id) {
        super(String.format("Podatoci was not found with this id: %ld",id));
    }
}
