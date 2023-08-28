package com.example.diansspring.service;

import com.example.diansspring.model.EducationAnimals;

import java.util.List;

public interface EducationAnimalService {
    void saveUserEducationAnimals(String name,
                                 String surname,
                                 String email,
                                 String phoneNumber,
                                 String selfDescription);

    List<EducationAnimals> listAll();

    void deleteAnimalsUserById(Long id);

}
