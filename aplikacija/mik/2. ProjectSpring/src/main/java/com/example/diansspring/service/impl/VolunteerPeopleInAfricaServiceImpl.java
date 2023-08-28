package com.example.diansspring.service.impl;

import com.example.diansspring.model.VolunteerPeopleInAfrica;
import com.example.diansspring.repository.jpa.VolunteerPeopleInAfricaRepository;
import com.example.diansspring.service.VolunteerPeopleInAfricaService;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class VolunteerPeopleInAfricaServiceImpl implements VolunteerPeopleInAfricaService {

    private final VolunteerPeopleInAfricaRepository volunteerPeopleInAfricaRepository;

    public VolunteerPeopleInAfricaServiceImpl(VolunteerPeopleInAfricaRepository volunteerPeopleInAfricaRepository) {
        this.volunteerPeopleInAfricaRepository = volunteerPeopleInAfricaRepository;
    }

    @Override
    public void saveVolunteerPeopleInAfricaUser(String name,
                                                String surname,
                                                String completeEducation,
                                                String email,
                                                String phoneNumber,
                                                String selfDescription) {

        VolunteerPeopleInAfrica vpa = new VolunteerPeopleInAfrica(name,
                surname,
                completeEducation,
                email,
                phoneNumber,
                selfDescription);

        this.volunteerPeopleInAfricaRepository.save(vpa);

    }

    @Override
    public List<VolunteerPeopleInAfrica> listAll() {
        return this.volunteerPeopleInAfricaRepository.findAll();
    }

    @Override
    public void deleteVolunteerPeopleInAfricaUserById(Long id) {
        this.volunteerPeopleInAfricaRepository.deleteById(id);
    }
}
