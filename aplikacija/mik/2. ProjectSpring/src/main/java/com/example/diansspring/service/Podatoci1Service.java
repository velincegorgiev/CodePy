package com.example.diansspring.service;

import com.example.diansspring.model.Podatoci;
import com.example.diansspring.model.Podatoci1;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Optional;

public interface Podatoci1Service {
    void reportProblemFromAnimals(String name,
                                  String email,
                                  String phoneNumber,
                                  String description,
                                  MultipartFile multipartFile,
                                  Float latitude,
                                  Float longitude);

    List<Podatoci1> getAllInfo();

    List<Podatoci1> listPodatoci1ByNameAndEmail(String name,
                                              String email);

    List<Podatoci1> listPodatoci1ByName(String name);

    List<Podatoci1> listPodatoci1ByEmail(String email);


    Optional<Podatoci1> findById(Long id);

    void deletePodatoci1ById(Long id);

    Optional<Podatoci1> edit(Long id, String name, String email, String description, String phoneNumber);
    Optional<Podatoci1> save(String name, String email, String description, String phoneNumber);
}
