package com.example.diansspring.model.exceptions;

public class UsernameAlreadyExistsException extends RuntimeException{

    public UsernameAlreadyExistsException(String username) {
        super(String.format("The username %s already exists!", username));
    }
}
