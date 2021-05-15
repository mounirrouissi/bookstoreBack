package com.example.demo.repos;

import com.example.demo.models.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository

public interface BookRepo extends JpaRepository<Book,Long> {
}
