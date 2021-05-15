package com.example.demo.authentication;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;


public class CustomAuth extends UsernamePasswordAuthenticationToken {
    public CustomAuth(Object principal, Object credentials) {
        super( principal, credentials );
    }


    public CustomAuth(Object principal, Object credentials, Collection<? extends GrantedAuthority> authorities) {
        super( principal, credentials, authorities );
    }
}
