package com.example.demo.models;

import javax.persistence.*;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import java.util.Set;


@Entity
@Table()
public class User {

    public User() {
    }


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String email;
    private String password;


    public Set<Authority> getAuthorities() {
        return authorities;
    }


    public void setAuthorities(Set<Authority> authorities) {
        this.authorities = authorities;
    }


    @OneToMany(fetch = FetchType.EAGER, orphanRemoval = true)
private Set<Authority> authorities;

    public String getEmail() {
        return email;
    }


    public String getPassword() {
        return password;
    }


    public User(String email, String password) {
        this.email = email;
        this.password = password;
    }


    public void setEmail(String email) {
        this.email = email;
    }


    public void setPassword(String password) {
        this.password = password;
    }
}
