package com.example.demo.controllers;

import com.example.demo.models.Book;
import com.example.demo.repos.ProductCategoryRepo;
import com.example.demo.service.BookService;
import lombok.var;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;
import java.util.stream.Stream;


@RestController
@CrossOrigin("*")
public class BookController {

private BookService bookService;
    private ProductCategoryRepo categoryRepo;

    public BookController(BookService bookService, ProductCategoryRepo categoryRepo) {
        this.bookService = bookService;

        this.categoryRepo = categoryRepo;
    }

    //the name should be page and size not p and s

    @GetMapping("/books/delete")
    public void deleteBook(@RequestBody Book book){
        this.bookService.delete(book);
    }

@GetMapping("/books")
public List<Book> getAllBooks(){
        return bookService.findAll();
}

    @GetMapping( "books/filter/date")
    public List<Book> getBooksByDate(){
        return bookService.findAll(Sort.by(Sort.Direction.ASC, "dateCreated"));
    }

    @GetMapping("/books/latest/{categoryId}")
    public List<Book> getLatestBooks(@PathVariable(name = "categoryId") int  id)
    {
        var category = categoryRepo.findById((long) id).get();
        System.out.println("Category ===="+category);
        return bookService.findFirst4ByCategories(category);

    }

   @GetMapping("/books/{id}")
    public Book getBook(@PathVariable(name = "id") int  id ){
        System.out.println(bookService.findById(Long.valueOf(id)));

        Book book=bookService.findById(Long.valueOf(id));
        return book ;

    }
    @GetMapping("/books/search/{text}")
    public Stream<Book> getBooks(@PathVariable(name = "text") String  text ){
        var book=bookService.findByNameContaining(text, Pageable.unpaged()).get();
        return book;
    }



/*    //Mobile API
    @GetMapping("/books/latest")
    public List<Book> getLatestBooks(){

        return  this.bookService.findLatest();
}

  @GetMapping("/books/best")
    public List<Book> getBestSellersBooks(){

        return  this.bookService.findLatest();
}*/



    @GetMapping("/books/search")
    public List<Book> getBooksForMobile(@RequestParam String  text ){
        var book=bookService.findByNameContainingMobile(text);
        return book;
    }



}

