package com.example.demo.security.services;

import com.example.demo.models.User;
import com.example.demo.models.Authority;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;


public class MyUserDetails implements UserDetails {


    private final boolean isAccountNonExpired=true;
    private final boolean isAccountNonLocked=true;
    private final boolean isCredentialsNonExpired=true;
    private final boolean isEnabled=true;



    private final User author;


    public MyUserDetails(User author) {
        this.author = author;
    }


    //generally this would be a seperate table in the database
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Set<Authority> roles = author.getAuthorities();
        List<SimpleGrantedAuthority> authorities = new ArrayList<>();

        for (Authority role : roles) {
            authorities.add(new SimpleGrantedAuthority(role.getName()));
        }
return  authorities;
    }


    @Override
    public String getPassword() {
        return author.getPassword();
    }


    @Override
    public String getUsername() {
        return author.getEmail();
    }


    @Override
    public boolean isAccountNonExpired() {
        return isAccountNonExpired;
    }


    @Override
    public boolean isAccountNonLocked() {
        return isAccountNonLocked;
    }


    @Override
    public boolean isCredentialsNonExpired() {
        return isCredentialsNonExpired;
    }


    @Override
    public boolean isEnabled() {
        return isEnabled;
    }
}
