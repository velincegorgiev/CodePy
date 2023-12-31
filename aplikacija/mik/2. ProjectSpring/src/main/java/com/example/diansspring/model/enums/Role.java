package com.example.diansspring.model.enums;

import org.springframework.security.core.GrantedAuthority;

public enum Role implements GrantedAuthority {


    ROLE_USER, ROLE_MOD, ROLE_ADMIN;
    @Override
    public String getAuthority() {
        return name();
    }
}
