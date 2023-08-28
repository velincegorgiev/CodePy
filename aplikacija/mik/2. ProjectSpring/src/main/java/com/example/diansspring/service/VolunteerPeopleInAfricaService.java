package com.example.diansspring.service;

import com.example.diansspring.model.VolunteerPeopleInAfrica;
import com.example.diansspring.model.VolunteerSmiljanci;

import java.util.List;

public interface VolunteerPeopleInAfricaService {

    void saveVolunteerPeopleInAfricaUser(String name,
                                    String surname,
                                         String completeEducation,
                                    String email,
                                    String phoneNumber,
                                    String selfDescription);

    List<VolunteerPeopleInAfrica> listAll();

    void deleteVolunteerPeopleInAfricaUserById(Long id);
}
