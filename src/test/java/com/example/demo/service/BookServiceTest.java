package com.example.demo.service;

import com.example.demo.repos.BookRepo;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.*;

class BookServiceTest {

    @MockBean
    private BookRepo bookRepo;
    @Test
    void findAll() {
    }

    @Test
    void testFindAll() {
    }

    @Test
    void findById() {
    }
}