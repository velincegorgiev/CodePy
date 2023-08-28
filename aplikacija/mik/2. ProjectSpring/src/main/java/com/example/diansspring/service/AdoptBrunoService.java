package com.example.diansspring.service;

import com.example.diansspring.model.AdoptBruno;

import java.util.List;

public interface AdoptBrunoService {

    void saveAdoptBrunoUser(String name,
                                         String surname,
                                         String homeAddress,
                                         String email,
                                         String phoneNumber,
                                         String acceptanceDescription);

    List<AdoptBruno> listAll();

    void deleteAdoptBrunoUserById(Long id);
}
