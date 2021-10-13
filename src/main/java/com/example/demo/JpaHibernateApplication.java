package com.example.demo;

import com.example.demo.models.Author;
import com.example.demo.models.Book;
import com.example.demo.models.Category;
import com.example.demo.repos.AuthorRepo;
import com.example.demo.repos.BookRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.math.BigDecimal;
import java.util.*;


@SpringBootApplication
public class JpaHibernateApplication implements CommandLineRunner {
private List<Author> lis=new ArrayList<>();
	@Autowired
	private AuthorRepo authorRepo;
	@Autowired
	private BookRepo bookRepo;


	public static void main(String[] args) {
		SpringApplication.run(JpaHibernateApplication.class, args);


	}


	@Override
	public void run(String... args) throws Exception {
		var category1 = new Category("Fiction");
			var category2 = new Category("Non-fiction");
			var bestSellerCat = new Category("BestSellers");

			List<Book> list=new ArrayList<>();



var b= new Book("VanderBilt"
		,BigDecimal.valueOf(10)
		,"book about good peaple"
		,"../.././../assets/images/books/b (1).jpg"
		,2
		   ,new Date(2021-03-11)
		   ,new Date(2021-03-11)
		   ,Set.of(category1, category2,bestSellerCat)

		,4.4
);

var b2= new Book("We are Family"
		,BigDecimal.valueOf(10)
		,"book about good peaple"
		,"../.././../assets/images/books/b (2).jpg"
		,2
		   ,new Date(2021-03-11)
		   ,new Date(2021-03-11)
		   ,Set.of(category1, category2,bestSellerCat),
		2.4
		);
var b3= new Book("The Dressmakers"
		,BigDecimal.valueOf(10)
		,"book about good peaple"
		,"../.././../assets/images/books/b (4).jpg"
		,2
		   ,new Date(2021-03-11)
		   ,new Date(2021-03-11)
		   ,Set.of(category1, category2)

		,3.4
		);


		List<Author> authors=new ArrayList<>();
		var author = new Author("Monir" );
		var Author1 = new Author("Joe Rogan",Set.of(b2));
		var Author2 = new Author("Tim Ferris",Set.of(b2,b3));
		author.addBooks(b);
		authors.add(author);
		authors.add(Author1);
		authors.add(Author2);


list.add(b);
list.add(b2);
list.add(b3);
		authorRepo.saveAll(authors);




	}}
