package com.example.diansspring.service;


import com.example.diansspring.model.EducationNature;

import java.util.List;

public interface EducationNatureService {
    void saveUserEducationNature(String name,
                                 String surname,
                                 String email,
                                 String phoneNumber,
                                 String selfDescription);

    List<EducationNature> listAll();

    void deleteNatureUserById(Long id);
}
