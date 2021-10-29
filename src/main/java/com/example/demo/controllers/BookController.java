package com.example.demo.controllers;

import com.example.demo.models.Book;
import com.example.demo.repos.ProductCategoryRepo;
import com.example.demo.service.BookService;
import lombok.var;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
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

    @DeleteMapping("/books/delete/{id}")
    public void deleteBook(@PathVariable("id") int id){
        this.bookService.delete(id);
    }
    @PutMapping("/books/update/{id}")
    public void updateBook(@PathVariable(name = "id")Long id,@RequestBody Book book){
        this.bookService.update(id,book);
    }
    @PostMapping("/books/add")
    public void addBook(@RequestBody Book book){

        this.bookService.add(book);
    }

@GetMapping("/books")
public List<Book> getAllBooks(){
        return bookService.findAll();
}

    @PostMapping( "books/filter/date")
    public List<Book> getBooksByDate(@RequestBody List<Book> books){
        System.out.println("sort by date called");
        return books.stream().sorted(Comparator.comparing(Book::getDatePublished)).collect(Collectors.toList());
//        return bookService.sortByDatePublished();
    }

    @GetMapping("/books/latest/{categoryId}")
    public List<Book> getLatestBooks(@PathVariable(name = "categoryId") int  id)
    {
        var category = categoryRepo.findById((long) id).get();
        System.out.println("Category ===="+category);
        var books =category.getBooks().stream().sorted(Comparator.comparing(Book::getDatePublished)).collect(Collectors.toList());
//        return bookService.findLatestByCategory(category);
return books;
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

