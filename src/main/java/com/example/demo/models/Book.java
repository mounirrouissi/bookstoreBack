package com.example.demo.models;


import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;


@Entity
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

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
    @CreationTimestamp
    private Date dateCreated;
    @UpdateTimestamp
    private Date dateUpdated;


    public Book() {
    }
@JsonIgnore
    public Set<Category> getCategories() {
        return categories;
    }

    public Book(String name, Set<Category> categories, int price) {
        this.name = name;
        this.categories = categories;
        this.price = BigDecimal.valueOf(price);
    }

    public Book(Long id, String name, BigDecimal price, String description, String imageUrl, int unitsInStock, Date dateCreated, Date dateUpdated) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.description = description;
        this.imageUrl = imageUrl;
        this.unitsInStock = unitsInStock;
        this.dateCreated = dateCreated;
        this.dateUpdated = dateUpdated;
    }

    public Book(String name,BigDecimal price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", description='" + description + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                '}';
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public String getDescription() {
        return description;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public int getUnitsInStock() {
        return unitsInStock;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public Date getDateUpdated() {
        return dateUpdated;
    }
}
