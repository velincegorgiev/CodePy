package com.example.diansspring.service.impl;

import com.example.diansspring.model.User;
import com.example.diansspring.model.enums.Role;
import com.example.diansspring.model.exceptions.*;
import com.example.diansspring.repository.jpa.UserRepository;
import com.example.diansspring.service.AuthService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


@Service
public class AuthServiceImpl implements AuthService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public AuthServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public User login(String username, String password) {
        if (username == null || username.isEmpty() ||
                password == null || password.isEmpty()) throw new InvalidArgumentException(username, password);

        return this.userRepository.findByUsernameAndPassword(username, password)
                .orElseThrow(InvalidUserCredentialsException::new);
    }

    @Override
    public User register(String name,
                         String surname,
                         String username,
                         String password,
                         String passwordRepeat,
                         Role userRole) {

        if (username == null || username.isEmpty() || password == null || password.isEmpty())
            throw new InvalidUserCredentialsException();
        if (!password.equals(passwordRepeat))
            throw new PasswordNotMatchingException();
        if (this.userRepository.findByUsername(username).isPresent())
            throw new UsernameAlreadyExistsException(username);

        User user = new User(name, surname, username, passwordEncoder.encode(password), userRole);
        return userRepository.save(user);
    }
}

