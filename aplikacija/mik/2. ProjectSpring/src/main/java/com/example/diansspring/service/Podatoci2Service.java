package com.example.diansspring.service;

import com.example.diansspring.model.Podatoci;
import com.example.diansspring.model.Podatoci2;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Optional;

public interface Podatoci2Service {
    void ideaForProject(String name,
                        String email,
                        String phoneNumber,
                        String description
                        );

    List<Podatoci2> getAllInfo();

    List<Podatoci2> listPodatoci2ByNameAndEmail(String name,
                                              String email);

    List<Podatoci2> listPodatoci2ByName(String name);

    List<Podatoci2> listPodatoci2ByEmail(String email);

    Optional<Podatoci2> findById(Long id);

    void deletePodatoci2ById(Long id);

    Optional<Podatoci2> edit(Long id, String name, String email, String description, String phoneNumber);
    Optional<Podatoci2> save(String name, String email, String description, String phoneNumber);
}
