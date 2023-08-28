package com.example.diansspring.repository.jpa;

import com.example.diansspring.model.VolunteerPeopleInAfrica;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VolunteerPeopleInAfricaRepository extends JpaRepository<VolunteerPeopleInAfrica, Long> {
}
