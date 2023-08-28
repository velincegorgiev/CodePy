package com.example.diansspring.service.impl;

import com.example.diansspring.model.VolunteerPeopleInAfrica;
import com.example.diansspring.model.VolunteerSmiljanci;
import com.example.diansspring.repository.jpa.VolunteerSmiljanciRepository;
import com.example.diansspring.service.VolunteerSmiljanciService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VolunteerSmiljanciServiceImpl implements VolunteerSmiljanciService {

    private final VolunteerSmiljanciRepository volunteerSmiljanciRepository;

    public VolunteerSmiljanciServiceImpl(VolunteerSmiljanciRepository volunteerSmiljanciRepository) {
        this.volunteerSmiljanciRepository = volunteerSmiljanciRepository;
    }


    @Override
    public void saveVolunteerSmiljanciUser(String name,
                                           String surname,
                                           String completeEducation,
                                           String email,
                                           String phoneNumber,
                                           String selfDescription) {

        VolunteerSmiljanci vs = new VolunteerSmiljanci(name,
                surname,
                completeEducation,
                email,
                phoneNumber,
                selfDescription);

        this.volunteerSmiljanciRepository.save(vs);

    }

    @Override
    public List<VolunteerSmiljanci> listAll() {
        return this.volunteerSmiljanciRepository.findAll();
    }

    @Override
    public void deleteVolunteerSmiljanciUserById(Long id) {
        this.volunteerSmiljanciRepository.deleteById(id);
    }
}
