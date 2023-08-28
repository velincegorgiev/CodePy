package com.example.diansspring.service;

import com.example.diansspring.model.Podatoci;
import org.springframework.expression.spel.support.ReflectivePropertyAccessor;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Optional;

public interface PodatociService {

    void reportProblemFromNature(String name,
                                 String email,
                                 String phoneNumber,
                                 String description,
                                 MultipartFile multipartFile,
                                 Float latitude,
                                 Float longitude);

    List<Podatoci> getAllInfo();

    List<Podatoci> listPodatociByNameAndEmail(String name,
                                              String email);

    List<Podatoci> listPodatociByName(String name);

    List<Podatoci> listPodatociByEmail(String email);

    Optional<Podatoci> findById(Long id);

    void deletePodatociById(Long id);

    Optional<Podatoci> edit(Long id, String name, String email, String description, String phoneNumber);

    Optional<Podatoci> save(String name, String email, String description, String phoneNumber);


}
