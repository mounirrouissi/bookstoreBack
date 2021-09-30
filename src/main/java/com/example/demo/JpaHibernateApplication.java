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

import java.util.ArrayList;
import java.util.List;
import java.util.Set;


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
			var category2 = new Category("Horror");
			List<Book> list=new ArrayList<>();
		for (int i = 0; i < 12; i++) {

			var  b = new Book("Azer"+i, Set.of(category1, category2),i*2);

list.add(b);
		}
//		for (int i = 0; i < 12; i++) {
//
//			var  b = new Book("Azer"+i, Set.of( category2),i*2);
//
//list.add(b);
//		}
		list.stream().forEach(x-> bookRepo.saveAll(list)
		);
		Author author = new Author(23,"Monir","Monir"  );
		authorRepo.save(author);


	}}
