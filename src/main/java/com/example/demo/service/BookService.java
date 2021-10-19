package com.example.demo.service;

import com.example.demo.models.Book;
import com.example.demo.models.Category;
import com.example.demo.repos.BookRepo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {
    private BookRepo bookRepo;


    public void delete(Long id){
        bookRepo.deleteById(id);
    }

    public void add(Book book){
        bookRepo.save(book);
    }



    public BookService(BookRepo bookRepo) {
        this.bookRepo = bookRepo;
    }

    public List<Book> findAll() {
        return bookRepo.findAll();
    }

    public List<Book> findAll(Sort dateCreated) {
        return bookRepo.findAll(Sort.by(Sort.Direction.ASC, "dateCreated"));
    }

    public List<Book> findFirst4ByCategories(Category category) {
        return bookRepo.findFirst4ByCategories(category);
    }

    public Book findById(Long id) {
        return bookRepo.findById(Long.valueOf(id)).get();
    }

    public Page<Book> findByNameContaining(String text, Pageable unpaged) {
        return bookRepo.findByNameContaining(text, Pageable.unpaged());
    }
 public List<Book> findByNameContainingMobile(String text) {
        return bookRepo.findByNameContaining(text);
    }

/*    public List<Book> findLatest() {
        return this.bookRepo.findLatest();
    }
    public List<Book> findBest() {
        return this.bookRepo.finBestByCategory();
    }*/
}
