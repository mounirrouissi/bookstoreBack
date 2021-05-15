package com.example.demo;

import com.example.demo.models.Author;
import com.example.demo.models.Authority;
import com.example.demo.models.Book;
import com.example.demo.models.User;
import com.example.demo.repos.AuthorRepo;
import com.example.demo.repos.BookRepo;
import com.example.demo.repos.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.Collections;


@SpringBootApplication
public class JpaHibernateApplication implements CommandLineRunner{
@Autowired
	UserRepo userRepo;

	@Autowired
private AuthorRepo authorRepo;

@Autowired
private PasswordEncoder passwordEncoder;

	public static void main(String[] args) {
		SpringApplication.run(JpaHibernateApplication.class, args);


	}


	@Override
	public void run(String... args) throws Exception {
		User user=new User("mounirrouissi2@gmail.com",passwordEncoder.encode( String.valueOf(  5)  ));
		for (int i = 5; i < 10; i++) {
			Author author= new Author(23,"Monir"+i,passwordEncoder.encode( String.valueOf(  i*10)  ) );
			Authority authority=new Authority("ADMIN",user);
			authorRepo.save(author );


		}

		userRepo.save( user );

}}
