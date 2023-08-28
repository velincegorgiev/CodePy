package com.example.diansspring.service.impl;


import com.example.diansspring.model.User;
import com.example.diansspring.model.enums.Role;
import com.example.diansspring.model.exceptions.InvalidUserCredentialsException;
import com.example.diansspring.model.exceptions.PasswordNotMatchingException;
import com.example.diansspring.model.exceptions.UserNotFoundException;
import com.example.diansspring.model.exceptions.UsernameAlreadyExistsException;
import com.example.diansspring.repository.jpa.UserRepository;
import com.example.diansspring.service.UserService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepository userRepository,
                           PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public User register(String name, String surname, String username, String password, String repeatPassword, Role userRole) {
        if (username == null || username.isEmpty() || password == null || password.isEmpty())
            throw new InvalidUserCredentialsException();
        if (!password.equals(repeatPassword))
            throw new PasswordNotMatchingException();
        if (this.userRepository.findByUsername(username).isPresent())
            throw new UsernameAlreadyExistsException(username);
        User user = new User(name, surname, username, passwordEncoder.encode(password), userRole);
        return userRepository.save(user);
    }

    @Override
    public List<User> listUsers() {
        return this.userRepository.findAll();
    }

    @Override
    public Optional<User> findById(Long id) {
        return this.userRepository.findById(id);
    }

    @Override
    public void deleteUserById(Long id) {
        this.userRepository.deleteById(id);
    }

    @Override
    public Optional<User> updateUser(Long id, String username, String name, String surname, Role role) {
        User u = this.userRepository.findById(id)
                        .orElseThrow(() -> new UserNotFoundException(id));

        u.setUsername(username);
        u.setName(name);
        u.setSurname(surname);
        u.setRole(role);

        return Optional.of(this.userRepository.save(u));
    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException(username));
    }
}
