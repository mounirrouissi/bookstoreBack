package com.example.demo.repos;

import com.example.demo.models.Book;
import com.example.demo.models.Category;
import org.springframework.data.domain.Page;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.*;


@Repository

public interface BookRepo extends JpaRepository<Book,Long> {
    @Query(nativeQuery = true,value = "select *\n" +
            "from book\n" +
            "order by date_created \n" +
            "limit 10 ")




    @Override
    List<Book> findAll();

    Page<Book> findByCategories(Category category,Pageable pageable);

    Page<Book> findByNameContaining(@RequestParam("name") String name,Pageable pageable);
    List<Book> findByNameContaining(@RequestParam("name") String name);

    List<Book> findFirst4ByCategories(Category category);
   @Query(value = "SELECT book_id FROM Book b JOIN b.categories c  where c.id IN  :ids"
           ,nativeQuery = true)
    List<Book> getCategoryBestsellerBooks(List<Long> ids);

    @Query(value = "SELECT * FROM Book b JOIN b.categories c  where c.name IN :name"
            ,nativeQuery = true)
    List<Book> finBestByCategory(@Param("name") String name);


    /*

    @Query(value = "SELECT b.name FROM Book b Category c WHERE c.id = 1 ",nativeQuery = true)
    Page<Book> findAllByCategoryID1(Pageable pageable);
*/





}
