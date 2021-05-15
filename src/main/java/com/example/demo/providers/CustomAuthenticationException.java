package com.example.demo.providers;

import org.springframework.security.core.AuthenticationException;


public class CustomAuthenticationException extends AuthenticationException {
    public CustomAuthenticationException(String msg, Throwable cause) {
        super( "ERROR", new Throwable("DFDSFSDFSDF") );

    }
}
