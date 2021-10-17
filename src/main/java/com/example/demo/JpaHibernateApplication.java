package com.example.demo;

import com.example.demo.models.Author;
import com.example.demo.models.Book;
import com.example.demo.models.Category;
import com.example.demo.repos.AuthorRepo;
import com.example.demo.repos.BookRepo;
import lombok.var;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;


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
		var fiction = new Category("Fiction");
			var nonFiction = new Category("Non-fiction");
			var bestSellerCat = new Category("BestSellers");

			List<Book> list=new ArrayList<>();

HashSet<Category> fictionCatSet=new HashSet<>();
fictionCatSet.add(fiction);
HashSet<Category> nonFictionCatSet=new HashSet<>();
nonFictionCatSet.add(nonFiction);
HashSet<Category> bestSellerCatSet=new HashSet<>();
		bestSellerCatSet.add(bestSellerCat);
var b= new Book("VanderBilt"
		,BigDecimal.valueOf(10)
		,"book about good peaple"
		,"../.././../assets/images/books/b (1).jpg"
		,2
		   ,new Date(2020,03,11)
		   ,new Date(2021-03-11)
		   ,fictionCatSet

		,4.4
);

var b2= new Book("We are Family"
		,BigDecimal.valueOf(10)
		,"book about good peaple"
		,"../.././../assets/images/books/b (2).jpg"
		,2
		   ,new Date(19,03,11)
		   ,new Date(2021-03-11)
		   ,nonFictionCatSet,
		2.4
		);
var b3= new Book("The Dressmakers"
		,BigDecimal.valueOf(10)
		,"book about good peaple"
		,"../.././../assets/images/books/b (4).jpg"
		,2
		   ,new Date(1021,03,11)
		   ,new Date(2021-03-11)
		   , Stream.concat(bestSellerCatSet.stream(), fictionCatSet.stream())
				   .collect(Collectors.toSet())

		,3.4
		);


		HashSet<Book> set2=new HashSet<>();
		set2.add(b2);
		set2.add(b);
	HashSet<Book> set3=new HashSet<>();
		set3.add(b2);
		set3.add(b3);

		List<Author> authors=new ArrayList<>();
		var author = new Author("Monir" );
		var Author1 = new Author("Joe Rogan",set2);
		var Author2 = new Author("Tim Ferris",set3);
		authors.add(author);
		authors.add(Author1);
		authors.add(Author2);


		authorRepo.saveAll(authors);




	}}
