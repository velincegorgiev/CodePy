package com.example.diansspring.model;



import lombok.Data;

import javax.persistence.*;


@Data
@Entity
public class Podatoci {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    private String email;

    private String phoneNumber;

    private String description;

    private Float latitude;
    private Float longitude;

    @Lob
    @Column(length = 16777215)
    private String image;

    @ManyToOne
    private User user;

    public Podatoci() {
    }

    public Podatoci(String name, String email, String phoneNumber, String description, String image, User user) {
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.description = description;
        this.image = image;
        this.user = user;
    }
}
