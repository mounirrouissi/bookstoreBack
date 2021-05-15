package com.example.demo.controllers;

import com.example.demo.models.Author;
import com.example.demo.models.Book;
import com.example.demo.models.User;
import com.example.demo.providers.CustomAuthenticationException;
import com.example.demo.providers.CustomProvider;
import com.example.demo.repos.AuthorRepo;
import com.example.demo.repos.BookRepo;
import jdk.jshell.Snippet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController

public class Controller {
    @Autowired
    CustomProvider customProvider;
    @Autowired
    private AuthorRepo authorRepo;
    @Autowired
    private BookRepo bookRepo;
/*    @GetMapping("/")
    public String getBoos()
    {
        return "Hello";
    }*/
    @PostMapping("/login")
       public   String login(@RequestBody User reqUUser)
    {
        try {
            Authentication authentication;
            UsernamePasswordAuthenticationToken token=new UsernamePasswordAuthenticationToken( reqUUser.getEmail(),reqUUser.getPassword() );
            authentication=this.customProvider.authenticate( token );
            return "Succusssful";
        } catch (CustomAuthenticationException e) {
            e.printStackTrace();
        }
        return "";
    }
    @GetMapping("/books")
    public List<Book> getBooks()
    {
        return bookRepo.findAll();
    }
    @GetMapping("/authors")
    public List<Author> getAuthors()
    {
        return this.authorRepo.findAll();
    }
}
