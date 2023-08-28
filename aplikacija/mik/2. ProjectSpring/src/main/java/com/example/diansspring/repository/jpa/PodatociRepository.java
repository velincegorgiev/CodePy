package com.example.diansspring.repository.jpa;

import com.example.diansspring.model.Podatoci;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PodatociRepository extends JpaRepository<Podatoci, Long> {
    List<Podatoci> findAllByNameLikeAndEmailLike(String name, String email);
    List<Podatoci> findAllByNameLike(String name);
    List<Podatoci> findAllByEmailLike(String email);
}
