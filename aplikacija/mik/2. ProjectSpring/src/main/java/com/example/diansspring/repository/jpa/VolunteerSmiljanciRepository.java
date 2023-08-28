package com.example.diansspring.repository.jpa;

import com.example.diansspring.model.VolunteerSmiljanci;
import jdk.jfr.Registered;
import org.springframework.data.jpa.repository.JpaRepository;

@Registered
public interface VolunteerSmiljanciRepository extends JpaRepository<VolunteerSmiljanci, Long> {
}
