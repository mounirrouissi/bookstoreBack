package com.example.demo.controllers;

import com.example.demo.models.Author;
import com.example.demo.models.Book;
import com.example.demo.repos.AuthorRepo;
import com.example.demo.repos.BookRepo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.server.PathParam;


@RestController
@CrossOrigin("*")
public class BookController {


    private BookRepo bookRepo;

    public BookController(AuthorRepo authorRepo, BookRepo bookRepo ) {
        this.bookRepo = bookRepo;

    }

    //the name should be page and size not p and s


    @GetMapping("/books")
    public Page<Book> getBooks(@PathParam("page")Integer page, @PathParam("size")Integer size)

    {
       return bookRepo.findAll(PageRequest.of(page,size));

    }





}

