package com.example.diansspring.service.impl;

import com.example.diansspring.model.Podatoci;
import com.example.diansspring.model.Podatoci2;
import com.example.diansspring.model.exceptions.Podatoci2NotFoundException;
import com.example.diansspring.repository.jpa.Podatoci2Repository;
import com.example.diansspring.service.Podatoci2Service;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import javax.transaction.Transactional;
import java.io.IOException;
import java.util.Base64;
import java.util.List;
import java.util.Optional;

@Service
public class Podatoci2ServiceImpl implements Podatoci2Service {

    private final Podatoci2Repository podatoci2Repository;

    public Podatoci2ServiceImpl(Podatoci2Repository podatoci2Repository) {
        this.podatoci2Repository = podatoci2Repository;
    }


    @Override
    @Transactional
    public void ideaForProject(String name, String email, String phoneNumber, String description) {
        Podatoci2 p = new Podatoci2();
        p.setName(name);
        p.setEmail(email);
        p.setPhoneNumber(phoneNumber);
        p.setDescription(description);


        this.podatoci2Repository.save(p);
    }

    @Override
    @Transactional
    public List<Podatoci2> getAllInfo() {
        return this.podatoci2Repository.findAll();
    }

    @Override
    @Transactional
    public List<Podatoci2> listPodatoci2ByNameAndEmail(String name, String email) {
        String nameLike = "%" + name + "%";
        String emailLike = "%" + email + "%";
        if(name != null && email != null) {
            return this.podatoci2Repository.findAllByNameLikeAndEmailLike(nameLike, emailLike);
        } else if(name != null) {
            return this.listPodatoci2ByName(name);
        } else if(email != null) {
            return this.listPodatoci2ByEmail(email);
        } else {
            return this.podatoci2Repository.findAll();
        }
    }

    @Override
    @Transactional
    public List<Podatoci2> listPodatoci2ByName(String name) {
        String nameLike = "%" + name + "%";
        return this.podatoci2Repository.findAllByNameLike(nameLike);
    }

    @Override
    @Transactional
    public List<Podatoci2> listPodatoci2ByEmail(String email) {
        String emailLike = "%" + email + "%";
        return this.podatoci2Repository.findAllByEmailLike(emailLike);
    }

    @Override
    @Transactional
    public Optional<Podatoci2> findById(Long id) {
        return this.podatoci2Repository.findById(id);
    }

    @Override
    @Transactional
    public void deletePodatoci2ById(Long id) {
        this.podatoci2Repository.deleteById(id);
    }

    @Override
    @Transactional
    public Optional<Podatoci2> edit(Long id, String name, String email, String description, String phoneNumber) {
        Podatoci2 p = this.podatoci2Repository
                .findById(id)
                .orElseThrow(() -> new Podatoci2NotFoundException(id));

        p.setName(name);
        p.setEmail(email);
        p.setDescription(description);
        p.setPhoneNumber(phoneNumber);

        return Optional.of(this.podatoci2Repository.save(p));
    }

    @Override
    @Transactional
    public Optional<Podatoci2> save(String name, String email, String description, String phoneNumber) {
        return Optional.empty();
    }
}
