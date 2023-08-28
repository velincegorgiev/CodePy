package com.example.diansspring.service.impl;

import com.example.diansspring.model.EducationAnimals;
import com.example.diansspring.repository.jpa.EducationAnimalsRepository;
import com.example.diansspring.service.EducationAnimalService;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class EducationAnimalsServiceImpl implements EducationAnimalService {

    private final EducationAnimalsRepository educationAnimalsRepository;

    public EducationAnimalsServiceImpl(EducationAnimalsRepository educationAnimalsRepository) {
        this.educationAnimalsRepository = educationAnimalsRepository;
    }

    @Override
    public void saveUserEducationAnimals(String name, String surname, String email, String phoneNumber, String selfDescription) {
        EducationAnimals ea = new EducationAnimals(name, surname, email, phoneNumber, selfDescription);

        this.educationAnimalsRepository.save(ea);
    }

    @Override
    public List<EducationAnimals> listAll() {
        return this.educationAnimalsRepository.findAll();
    }

    @Override
    public void deleteAnimalsUserById(Long id) {
        this.educationAnimalsRepository.deleteById(id);
    }
}
