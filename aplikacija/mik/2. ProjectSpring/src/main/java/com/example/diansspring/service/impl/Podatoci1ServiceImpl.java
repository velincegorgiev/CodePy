package com.example.diansspring.service.impl;

import com.example.diansspring.model.Podatoci;
import com.example.diansspring.model.Podatoci1;
import com.example.diansspring.model.exceptions.Podatoci1NotFoundException;
import com.example.diansspring.repository.jpa.Podatoci1Repository;
import com.example.diansspring.service.Podatoci1Service;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import javax.transaction.Transactional;
import java.io.IOException;
import java.util.Base64;
import java.util.List;
import java.util.Optional;


@Service
public class Podatoci1ServiceImpl implements Podatoci1Service {

    private final Podatoci1Repository podatoci1Repository;

    public Podatoci1ServiceImpl(Podatoci1Repository podatoci1Repository) {
        this.podatoci1Repository = podatoci1Repository;
    }

    @Override
    @Transactional
    public void reportProblemFromAnimals(String name, String email, String phoneNumber, String description, MultipartFile multipartFile, Float latitude, Float longitude) {
        Podatoci1 p = new Podatoci1();
        String fileName = StringUtils.cleanPath(multipartFile.getOriginalFilename());
        if(fileName.contains(".."))
        {
            System.out.println("not a a valid file");
        }
        try {
            p.setImage(Base64.getEncoder().encodeToString(multipartFile.getBytes()));
        } catch (IOException e) {
            e.printStackTrace();
        }
        p.setName(name);
        p.setEmail(email);
        p.setPhoneNumber(phoneNumber);
        p.setDescription(description);
        p.setLatitude(latitude);
        p.setLongitude(longitude);


        this.podatoci1Repository.save(p);
    }

    @Override
    @Transactional
    public List<Podatoci1> getAllInfo() {
        return this.podatoci1Repository.findAll();
    }

    @Override
    @Transactional
    public List<Podatoci1> listPodatoci1ByNameAndEmail(String name, String email) {
        String nameLike = "%" + name + "%";
        String emailLike = "%" + email + "%";
        if(name != null && email != null) {
            return this.podatoci1Repository.findAllByNameLikeAndEmailLike(nameLike, emailLike);
        } else if(name != null) {
            return this.listPodatoci1ByName(name);
        } else if(email != null) {
            return this.listPodatoci1ByEmail(email);
        } else {
            return this.podatoci1Repository.findAll();
        }
    }

    @Override
    @Transactional
    public List<Podatoci1> listPodatoci1ByName(String name) {
        String nameLike = "%" + name + "%";
        return this.podatoci1Repository.findAllByNameLike(nameLike);
    }

    @Override
    @Transactional
    public List<Podatoci1> listPodatoci1ByEmail(String email) {
        String emailLike = "%" + email + "%";
        return this.podatoci1Repository.findAllByEmailLike(emailLike);
    }

    @Override
    @Transactional
    public Optional<Podatoci1> findById(Long id) {
        return this.podatoci1Repository.findById(id);
    }

    @Override
    @Transactional
    public void deletePodatoci1ById(Long id) {
        this.podatoci1Repository.deleteById(id);
    }

    @Override
    @Transactional
    public Optional<Podatoci1> edit(Long id, String name, String email, String description, String phoneNumber) {
        Podatoci1 p = this.podatoci1Repository
                .findById(id)
                .orElseThrow(() -> new Podatoci1NotFoundException(id));

        p.setName(name);
        p.setEmail(email);
        p.setDescription(description);
        p.setPhoneNumber(phoneNumber);

        return Optional.of(this.podatoci1Repository.save(p));
    }

    @Override
    @Transactional
    public Optional<Podatoci1> save(String name, String email, String description, String phoneNumber) {
        return Optional.empty();
    }

}


