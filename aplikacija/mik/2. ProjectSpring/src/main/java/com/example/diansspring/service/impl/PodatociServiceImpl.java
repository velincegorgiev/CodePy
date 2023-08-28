package com.example.diansspring.service.impl;

import com.example.diansspring.model.Podatoci;
import com.example.diansspring.model.exceptions.PodatociNotFoundException;
import com.example.diansspring.repository.jpa.PodatociRepository;
import com.example.diansspring.service.PodatociService;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import javax.transaction.Transactional;
import java.io.IOException;
import java.util.Base64;
import java.util.List;
import java.util.Optional;

@Service
public class PodatociServiceImpl implements PodatociService {

    private final PodatociRepository podatociRepository;

    public PodatociServiceImpl(PodatociRepository podatociRepository) {
        this.podatociRepository = podatociRepository;
    }

    @Override
    @Transactional
    public void reportProblemFromNature(String name, String email, String phoneNumber, String description, MultipartFile multipartFile, Float latitude, Float longitude) {
        Podatoci p = new Podatoci();
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


        podatociRepository.save(p);
    }

    @Override
    @Transactional
    public List<Podatoci> getAllInfo() {
        return this.podatociRepository.findAll();
    }

    @Override
    @Transactional
    public List<Podatoci> listPodatociByNameAndEmail(String name, String email) {
        String nameLike = "%" + name + "%";
        String emailLike = "%" + email + "%";
        if(name != null && email != null) {
            return this.podatociRepository.findAllByNameLikeAndEmailLike(nameLike, emailLike);
        } else if(name != null) {
            return this.listPodatociByName(name);
        } else if(email != null) {
            return this.listPodatociByEmail(email);
        } else {
            return this.podatociRepository.findAll();
        }
    }

    @Override
    @Transactional
    public List<Podatoci> listPodatociByName(String name) {
        String nameLike = "%" + name + "%";
        return this.podatociRepository.findAllByNameLike(nameLike);
    }

    @Override
    @Transactional
    public List<Podatoci> listPodatociByEmail(String email) {
        String emailLike = "%" + email + "%";
        return this.podatociRepository.findAllByEmailLike(emailLike);
    }

    @Override
    @Transactional

    public Optional<Podatoci> findById(Long id) {
        return this.podatociRepository.findById(id);
    }

    @Override
    @Transactional
    public void deletePodatociById(Long id) {
        this.podatociRepository.deleteById(id);
    }

    @Override
//    @Transactional
    public Optional<Podatoci> edit(Long id, String name, String email, String description, String phoneNumber) {
        Podatoci p = this.podatociRepository
                .findById(id)
                .orElseThrow(() -> new PodatociNotFoundException(id));

        p.setName(name);
        p.setEmail(email);
        p.setDescription(description);
        p.setPhoneNumber(phoneNumber);

        return Optional.of(this.podatociRepository.save(p));
    }

    @Override
    @Transactional
    public Optional<Podatoci> save(String name, String email, String description, String phoneNumber) {

        return Optional.empty();
    }
}
