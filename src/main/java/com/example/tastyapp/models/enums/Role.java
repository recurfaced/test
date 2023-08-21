package com.example.tastyapp.models.enums;

import org.springframework.security.core.GrantedAuthority;

public enum Role implements GrantedAuthority {
    ROLE_USER, ROLE_ADMIN,ROLE_CHEF,ROLE_CHEF1;

    @Override
    public String getAuthority() {
        return name();
    }
}
