package com.example.demo.controllers;

import com.example.demo.models.Book;
import com.example.demo.models.Category;
import com.example.demo.repos.BookRepo;
import com.example.demo.repos.ProductCategoryRepo;
import lombok.var;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;


@RestController
@CrossOrigin("*")
public class CategoryController {
    private ProductCategoryRepo categoryRepo;
    private BookRepo bookRepo;
    public CategoryController(ProductCategoryRepo categoryRepo, BookRepo bookRepo) {
        this.categoryRepo = categoryRepo;
        this.bookRepo = bookRepo;
    }


// comment here again
    @RequestMapping(value = "/categories",method = RequestMethod.GET)
    public List<Category> getCategory() {
        System.out.println("categories called ");
        return categoryRepo.findAll();
    }

    @GetMapping("category/{id}")
    public Category getCategoryById(@PathVariable int id) {
        System.out.println("someone called id catgory");
        var category = categoryRepo.findById(Long.valueOf(id));
        return category.get();
    }

    @GetMapping(value="/categories/{id}",params = { "page", "size" } )
    public Page<Book> getBooksByCategory(@PathVariable int id, @RequestParam(value="page",required=false) Integer page , @RequestParam(value = "size",required = false) Integer size) {
       var byId = categoryRepo.findById((long) id).get();
//        var byName = categoryRepo.findAllByName(name).get();
        System.out.println(id +"category called here by id");

        return bookRepo.findByCategories(byId, PageRequest.of(page, size));


    }
    @RequestMapping(value="/categories/name",params = { "name","page","size" }   )
    public Page<Book> getBooksByCategoryName(@RequestParam(value = "name") String name,@RequestParam(value = "page") int page, @RequestParam(value = "size") int size){
       var byId = categoryRepo.findByName(name);
        System.out.println(name +"category called here by name");
//        var byName = categoryRepo.findAllByName(name).get();

        return bookRepo.findByCategories(byId, PageRequest.of(page, size));


    }



    //for android retrofit


    @GetMapping("/categories/{id}/bestseller")
    public Set<Book> getCategoryBestsellerBooks(@PathVariable int id)
    {
        var category = categoryRepo.findById((long) id).get();
        var bestCategory = categoryRepo.findByName("BestSellers");
        System.out.println("passed id =="+id);

        var bookList = category.getBooks();
        Set<Book> list = bookList.stream().filter(b->b.getCategories().contains(bestCategory) ).collect(Collectors.toSet());


        return list;
    }
    @GetMapping("/categories/latest")
    public List<Category> getCategoryLastestBooks() {
        return categoryRepo.findAll();
    }



}
