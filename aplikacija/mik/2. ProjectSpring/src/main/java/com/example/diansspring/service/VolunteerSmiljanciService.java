package com.example.diansspring.service;

import com.example.diansspring.model.VolunteerSmiljanci;

import java.util.List;

public interface VolunteerSmiljanciService {

    void saveVolunteerSmiljanciUser(String name,
                                  String surname,
                                  String completeEducation,
                                  String email,
                                  String phoneNumber,
                                  String selfDescription);

    List<VolunteerSmiljanci> listAll();

    void deleteVolunteerSmiljanciUserById(Long id);
}
