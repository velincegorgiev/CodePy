package com.example.diansspring.repository.jpa;


import com.example.diansspring.model.EducationAnimals;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EducationAnimalsRepository extends JpaRepository<EducationAnimals, Long> {
}
