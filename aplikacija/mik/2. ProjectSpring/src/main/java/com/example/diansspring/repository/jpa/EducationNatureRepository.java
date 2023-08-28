package com.example.diansspring.repository.jpa;

import com.example.diansspring.model.EducationNature;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EducationNatureRepository extends JpaRepository<EducationNature, Long> {
}
