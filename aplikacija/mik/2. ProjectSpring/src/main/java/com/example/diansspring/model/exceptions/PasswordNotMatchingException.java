package com.example.diansspring.model.exceptions;

public class PasswordNotMatchingException extends RuntimeException{

    public PasswordNotMatchingException() {
        super(String.format("The following passwords do not match!"));
    }
}
