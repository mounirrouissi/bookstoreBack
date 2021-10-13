package com.example.demo.models;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;


@Entity
 @Getter
@ToString

public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    private Double ratings;
    @ManyToMany(mappedBy = "books")
    private Set<Author> authors = new HashSet<>();

    @ManyToMany(cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinTable(name = "book_category",
            joinColumns =@JoinColumn(name="book_id"),
            inverseJoinColumns =@JoinColumn(name = "category_id")
    )
    private Set<Category> categories=new HashSet<>();

    private BigDecimal price;
    private String description;
    private String imageUrl;
    private int unitsInStock;
    @DateTimeFormat(pattern = "dd.MM.yyyy")
    @JsonFormat(pattern="yyyy-MM-dd")
    private Date datePublished;
    @UpdateTimestamp
    private Date dateUpdated;

    public void setDateCreated(Date dateCreated) {
        this.datePublished = dateCreated;
    }

    public Book() {
    }
@JsonIgnore
    public Set<Category> getCategories() {
        return categories;
    }

    public Set<Author> getAuthors() {
        return authors;
    }



    public Book(String name, BigDecimal price, String description, String imageUrl, int unitsInStock, Date dateCreated,
                Date dateUpdated , Set<Category> categories, Double ratings)
    {

        this.name = name;
        this.price = price;
        this.description = description;
        this.imageUrl = imageUrl;
        this.unitsInStock = unitsInStock;
        this.datePublished = dateCreated;
        this.dateUpdated = dateUpdated;
        this.categories = categories;
this.ratings=ratings;
    }


}
