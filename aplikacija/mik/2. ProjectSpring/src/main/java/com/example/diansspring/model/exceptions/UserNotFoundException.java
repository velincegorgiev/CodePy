package com.example.diansspring.model.exceptions;

public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException(Long id) {
        super(String.format("User with id: %ld does not exist.",id));
    }
}
