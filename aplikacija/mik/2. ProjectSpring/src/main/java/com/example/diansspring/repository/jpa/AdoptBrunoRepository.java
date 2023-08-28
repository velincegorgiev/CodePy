package com.example.diansspring.repository.jpa;

import com.example.diansspring.model.AdoptBruno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdoptBrunoRepository extends JpaRepository<AdoptBruno, Long> {
}
