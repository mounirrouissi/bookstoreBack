package com.example.demo.models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


@Entity
public class Author {

    public Long getId() {
        return id;
    }


    public void setId(Long id) {
        this.id = id;
    }


    public int getAge() {
        return age;
    }


    public void setAge(int age) {
        this.age = age;
    }


    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name = name;
    }


    public void setBooks(Set<Book> books) {
        this.books = books;
    }


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int age;
    private String name;
    private String password;





    public Author() {
    }





    public Author(int age, String name, String password) {
        this.age = age;
        this.name = name;
        this.password = password;

    }





    public String getPassword() {

        return password;
    }

//set not list
    //no remove cascade
    @ManyToMany(cascade = {CascadeType.MERGE,CascadeType.PERSIST})
    @JoinTable(
            name="author_book",
            joinColumns=@JoinColumn(name = "author_id"),
            inverseJoinColumns=@JoinColumn(name = "book_id")
    )
    private Set<Book> books = new HashSet<>();


    public Set<Book> getBooks() {
        return books;
    }

/*
    public void addAutho(Authority auth) {
        if (authorities==null)
            authorities =new ArrayList<>();
        this.authorities.add( auth );
    }*/


/*
    @Override
    public String toString() {
        return "Author{" +
                "id=" + id +
                ", age=" + age +
                ", name='" + name + '\'' +
                '}';
    }

*/


    /*HELPING METHODS*/


}


