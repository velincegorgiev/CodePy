package com.example.diansspring.model.exceptions;

public class InvalidUserRegisterException extends RuntimeException{

    public InvalidUserRegisterException() {
        super(String.format("You must fill all the black fields in order to register!"));
    }
}
