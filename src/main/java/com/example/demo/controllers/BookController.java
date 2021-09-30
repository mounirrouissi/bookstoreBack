package com.example.demo.controllers;

import com.example.demo.models.Book;
import com.example.demo.repos.BookRepo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.server.PathParam;
import java.util.List;
import java.util.stream.Stream;


@RestController
@CrossOrigin("*")
public class BookController {


    private BookRepo bookRepo;

    public BookController(BookRepo bookRepo ) {
        this.bookRepo = bookRepo;

    }

    //the name should be page and size not p and s


    @GetMapping("/books")
    public Page<Book> getBooks(@PathParam("page")Integer page, @PathParam("size")Integer size)

    {
       return bookRepo.findAll(PageRequest.of(page,size));

    }

    @GetMapping("/mobile/books")
    public List<Book> getBooks()

    {
       return bookRepo.findAll();

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

