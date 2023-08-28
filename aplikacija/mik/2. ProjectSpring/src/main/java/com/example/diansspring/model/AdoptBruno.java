package com.example.diansspring.model;


import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@Entity
public class AdoptBruno {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    private String surname;

    private String homeAddress;

    private String email;

    private String phoneNumber;

    private String acceptanceDescription;

    public AdoptBruno() {
    }

    public AdoptBruno(String name,
                      String surname,
                      String homeAddress,
                      String email,
                      String phoneNumber,
                      String acceptanceDescription) {
        this.name = name;
        this.surname = surname;
        this.homeAddress = homeAddress;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.acceptanceDescription = acceptanceDescription;
    }
}
