package com.example.diansspring.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Data
@Entity
public class VolunteerSmiljanci {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    private String surname;

    private String completeEducation;

    private String email;

    private String phoneNumber;

    private String helpDescription;

    public VolunteerSmiljanci() {
    }

    public VolunteerSmiljanci(String name,
                              String surname,
                              String completeEducation,
                              String email,
                              String phoneNumber,
                              String helpDescription) {
        this.name = name;
        this.surname = surname;
        this.completeEducation = completeEducation;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.helpDescription = helpDescription;
    }
}
