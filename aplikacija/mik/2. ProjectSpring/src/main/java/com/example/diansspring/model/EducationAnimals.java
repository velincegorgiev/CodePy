package com.example.diansspring.model;


import lombok.Data;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@Entity
public class EducationAnimals {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    private String surname;

    private String email;

    private String phoneNumber;

    private String selfDescription;

    public EducationAnimals() {
    }

    public EducationAnimals(String name, String surname, String email, String phoneNumber, String selfDescription) {
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.selfDescription = selfDescription;
    }
}
