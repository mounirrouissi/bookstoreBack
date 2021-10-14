package com.example.demo.controllers;

import com.example.demo.models.Book;
import com.example.demo.models.Category;
import com.example.demo.repos.BookRepo;
import com.example.demo.service.BookService;
import lombok.var;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(BookController.class)
class BookControllerTest {

    @Autowired
  private   MockMvc mockMvc;

    @MockBean
    private BookService bookRepo;
    @Test
    void getAllBooks() throws Exception {
        this.mockMvc
                .perform(get("/books"))
                .andExpect(status().isOk());
    }
}