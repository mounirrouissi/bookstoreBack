package com.example.demo.repos;

import com.example.demo.models.Book;
import com.example.demo.models.order.Customer;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import java.time.ZonedDateTime;

import static org.junit.jupiter.api.Assertions.*;


@DataJpaTest
class BookRepoTest {


    @Autowired
    private BookRepo bookRepo;

    @Autowired
    private TestEntityManager testEntityManager;

    @Test
    void shouldSaveAndRetrieveJpaEntity() {
        Book book1 = new Book(1L,"book  test");


        Book result = testEntityManager.persistFlushFind(book1);

        assertNotNull(result.getId());
    }

    @Test
    void findAll() {
    }

    @Test
    void findByCategories() {
    }

    @Test
    void findByCategoriesId() {
    }

    @Test
    void findByNameContaining() {
    }
}