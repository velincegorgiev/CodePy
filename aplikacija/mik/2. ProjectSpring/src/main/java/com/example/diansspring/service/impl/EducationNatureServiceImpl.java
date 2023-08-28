package com.example.diansspring.service.impl;

import com.example.diansspring.model.EducationNature;
import com.example.diansspring.repository.jpa.EducationNatureRepository;
import com.example.diansspring.service.EducationNatureService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EducationNatureServiceImpl implements EducationNatureService {

    private final EducationNatureRepository educationNatureRepository;

    public EducationNatureServiceImpl(EducationNatureRepository educationNatureRepository) {
        this.educationNatureRepository = educationNatureRepository;
    }

    @Override
    public void saveUserEducationNature(String name, String surname, String email, String phoneNumber, String selfDescription) {
        EducationNature en = new EducationNature(name, surname, email, phoneNumber, selfDescription);
        this.educationNatureRepository.save(en);
    }

    @Override
    public List<EducationNature> listAll() {
        return this.educationNatureRepository.findAll();
    }

    @Override
    public void deleteNatureUserById(Long id) {
        this.educationNatureRepository.deleteById(id);
    }
}
