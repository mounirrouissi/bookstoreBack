package com.example.demo.models;

import com.example.demo.repos.BookRepo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;
import java.util.List;
import java.util.Set;


@Entity
@NoArgsConstructor
public class Category   {
public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
    @Column(unique = true)
    private String name;
    @ManyToMany(mappedBy = "categories")
    private List<Book> books;
@JsonIgnore
    public List<Book> getBooks() {

        return books;
    }

    public Category(String name) {

        this.name = name;
    }
}
