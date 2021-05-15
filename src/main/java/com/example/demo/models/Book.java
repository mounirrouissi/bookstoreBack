package com.example.demo.models;


import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;


@Entity
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;




    private String name;

    @ManyToMany(cascade = {CascadeType.MERGE,CascadeType.PERSIST},mappedBy = "books")
  private Set<Author> authors=new HashSet<>();


    public Book() {
    }


    public Long getId() {
        return id;
    }


    public String getName() {
        return name;
    }
}
