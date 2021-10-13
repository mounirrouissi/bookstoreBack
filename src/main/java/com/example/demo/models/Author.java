package com.example.demo.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;


@Entity
@NoArgsConstructor
@Getter
public class Author {






    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;




    //set not list
    //no remove cascade
    @ManyToMany(cascade = {CascadeType.ALL})
    @JoinTable(
            name="author_book",
            joinColumns=@JoinColumn(name = "author_id"),
            inverseJoinColumns=@JoinColumn(name = "book_id"))
    private Set<Book> books = new HashSet<>();

    @JsonIgnore
    public Set<Book> getBooks() {
        return books;
    }

    public void addBooks(Book book){
        this.books.add(book);
    }

    public Author(String name) {
        this.name = name;
    }

    public Author(String name, Set<Book> books) {
        this.name = name;
        this.books=books;
    }









    /*HELPING METHODS*/


}


