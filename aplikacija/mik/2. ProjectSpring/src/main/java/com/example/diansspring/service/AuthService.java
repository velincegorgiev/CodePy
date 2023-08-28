package com.example.diansspring.service;

import com.example.diansspring.model.User;
import com.example.diansspring.model.enums.Role;

public interface AuthService {
    User login(String username, String password);

    User register(String name,
                  String surname,
                  String username,
                  String password,
                  String passwordRepeat,
                  Role userRole);
}
