package com.example.demo.service;

import com.example.demo.models.Book;
import com.example.demo.models.Category;
import com.example.demo.repos.BookRepo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class BookService {
    private BookRepo bookRepo;


    public void delete(int id){
        System.out.println(" delete book caled here ");
        bookRepo.deleteById((long) id);
    }

    public void add(Book book){
        if(!bookRepo.findById(book.getId()).isPresent())
        bookRepo.save(book);

    }


    public ResponseEntity<Book> update(Long id,Book book){
        Optional<Book> dbBook = bookRepo.findById(book.getId());
        if(dbBook.isPresent())
        {
            dbBook.get().setName(book.getName());
            dbBook.get().setRatings(book.getRatings());
            dbBook.get().setPrice(book.getPrice());
            dbBook.get().setImageUrl(book.getImageUrl());
            dbBook.get().setUnitsInStock(book.getUnitsInStock());
            dbBook.get().setAuthors(book.getAuthors());
            dbBook.get().setDescription(book.getDescription());
            dbBook.get().setCategories(book.getCategories());
            dbBook.get().setDateUpdated(new Date(System.currentTimeMillis()));

            dbBook.get().setDatePublished(book.getDatePublished());
            return new ResponseEntity<>(bookRepo.save(dbBook.get()), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }



    public BookService(BookRepo bookRepo) {
        this.bookRepo = bookRepo;
    }

    public List<Book> findAll() {
        return bookRepo.findAll();
    }

    public List<Book> sortByDatePublished() {
        return bookRepo.findAll(Sort.by(Sort.Direction.ASC, "datePublished"));
    }

    public List<Book> findLatestByCategory(Category category) {
        return bookRepo.findFirst4ByCategories(category);
    }

    public Book findById(Long id) {
        return bookRepo.findById(Long.valueOf(id)).get();
    }

    public Page<Book> findByNameContaining(String text, Pageable unpaged) {
        return bookRepo.findByNameContaining(text, Pageable.unpaged());
    }
 public List<Book> findByNameContainingMobile(String text) {
        return bookRepo.findByNameContainingIgnoreCase(text);
    }

/*    public List<Book> findLatest() {
        return this.bookRepo.findLatest();
    }
    public List<Book> findBest() {
        return this.bookRepo.finBestByCategory();
    }*/
}
