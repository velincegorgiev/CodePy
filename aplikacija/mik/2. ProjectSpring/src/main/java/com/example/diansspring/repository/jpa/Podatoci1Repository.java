package com.example.diansspring.repository.jpa;

import com.example.diansspring.model.Podatoci;
import com.example.diansspring.model.Podatoci1;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface Podatoci1Repository extends JpaRepository<Podatoci1, Long> {
    List<Podatoci1> findAllByNameLikeAndEmailLike(String name, String email);
    List<Podatoci1> findAllByNameLike(String name);
    List<Podatoci1> findAllByEmailLike(String email);
}
