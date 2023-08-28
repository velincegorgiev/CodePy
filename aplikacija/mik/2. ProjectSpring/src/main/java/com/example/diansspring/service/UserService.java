package com.example.diansspring.service;

import com.example.diansspring.model.User;
import com.example.diansspring.model.enums.Role;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;
import java.util.Optional;

public interface UserService extends UserDetailsService {
    User register(String name,
                  String surname,
                  String username,
                  String password,
                  String passwordRepeat,
                  Role role);

    List<User> listUsers();

    Optional<User> findById(Long id);

    void deleteUserById(Long id);

    Optional<User> updateUser(Long id, String username, String name, String surname, Role role);
}
