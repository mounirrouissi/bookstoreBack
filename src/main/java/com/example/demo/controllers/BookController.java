package com.example.demo.controllers;

import com.example.demo.models.Book;
import com.example.demo.repos.BookRepo;
import com.example.demo.repos.ProductCategoryRepo;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;
import java.util.stream.Stream;


@RestController
@CrossOrigin("*")
public class BookController {


    private BookRepo bookRepo;
    private ProductCategoryRepo categoryRepo;

    public BookController(BookRepo bookRepo, ProductCategoryRepo categoryRepo) {
        this.bookRepo = bookRepo;

        this.categoryRepo = categoryRepo;
    }

    //the name should be page and size not p and s


@GetMapping("/books")
public List<Book> getAllBooks(){
        return bookRepo.findAll();
}

    @GetMapping( "books/filter/date")
    public List<Book> getBooksByDate(){
        return bookRepo.findAll(Sort.by(Sort.Direction.ASC, "dateCreated"));
    }

    @GetMapping("/books/latest/{categoryId}")
    public List<Book> getLatestBooks(@PathVariable(name = "categoryId") int  id)
    {
        var category = categoryRepo.findById((long) id).get();
        System.out.println("Category ===="+category);
        return bookRepo.findFirst4ByCategories(category);

    }

   @GetMapping("/books/{id}")
    public Book getBook(@PathVariable(name = "id") int  id ){
        System.out.println(bookRepo.findById(Long.valueOf(id)).get());

        Book book=bookRepo.findById(Long.valueOf(id)).get();
        return book ;

    }
    @GetMapping("/books/search/{text}")
    public Stream<Book> getBooks(@PathVariable(name = "text") String  text ){
        var book=bookRepo.findByNameContaining(text, Pageable.unpaged()).get();
        return book;

    }



    @GetMapping("/books/latest")
    public List<Book> getLatestBooks(){

        return  this.bookRepo.findLatest();
}


}

