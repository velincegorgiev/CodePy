package com.example.diansspring.service.impl;

import com.example.diansspring.model.AdoptBruno;
import com.example.diansspring.repository.jpa.AdoptBrunoRepository;
import com.example.diansspring.service.AdoptBrunoService;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class AdoptBrunoServiceImpl implements AdoptBrunoService {

    private AdoptBrunoRepository adoptBrunoRepository;

    public AdoptBrunoServiceImpl(AdoptBrunoRepository adoptBrunoRepository) {
        this.adoptBrunoRepository = adoptBrunoRepository;
    }

    @Override
    public void saveAdoptBrunoUser(String name,
                                   String surname,
                                   String homeAddress,
                                   String email,
                                   String phoneNumber,
                                   String acceptanceDescription) {

        AdoptBruno ab = new AdoptBruno(name, surname, homeAddress, email, phoneNumber, acceptanceDescription);

        this.adoptBrunoRepository.save(ab);

    }

    @Override
    public List<AdoptBruno> listAll() {
        return this.adoptBrunoRepository.findAll();
    }

    @Override
    public void deleteAdoptBrunoUserById(Long id) {
        this.adoptBrunoRepository.deleteById(id);
    }
}
