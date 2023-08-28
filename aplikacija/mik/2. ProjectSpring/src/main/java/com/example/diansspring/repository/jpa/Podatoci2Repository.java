package com.example.diansspring.repository.jpa;

import com.example.diansspring.model.Podatoci;
import com.example.diansspring.model.Podatoci2;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface Podatoci2Repository extends JpaRepository<Podatoci2, Long> {
    List<Podatoci2> findAllByNameLikeAndEmailLike(String name, String email);
    List<Podatoci2> findAllByNameLike(String name);
    List<Podatoci2> findAllByEmailLike(String email);
}
