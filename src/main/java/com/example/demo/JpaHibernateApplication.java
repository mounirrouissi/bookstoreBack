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
var people= new Book("فن التعامل مع الناس"
		,BigDecimal.valueOf(10)
		,"فن التعامل مع الناس"
		,"https://firebasestorage.googleapis.com/v0/b/bookstore-4337f.appspot.com/o/%D9%81%D9%86%20%D8%A7%D9%84%D8%AA%D8%B9%D8%A7%D9%85%D9%84%20%D9%85%D8%B9%20%D8%A7%D9%84%D9%86%D8%A7%D8%B3.webp?alt=media&token=8d7b3bc2-8762-4f4b-9c4e-0c7bf12d453a"
		,2
		   ,new Date(1955,03,11)
		   ,new Date(2021-03-11)
		   ,fictionCatSet

		,4.4
);

var Rich_Dad= new Book("Rich Dad Poor Dad\n" + "(الأب الغنى والأب الفقير)\n"
		,BigDecimal.valueOf(10)
		,"Rich Dad Poor Dad هو كتاب عام 1997 كتبه روبرت كيوساكي وشارون ليشتر. يدعو إلى أهمية الثقافة المالية والاستقلال المالي وبناء الثروة من خلال الاستثمار في الأصول والاستثمار العقاري وبدء الأعمال التجارية وامتلاكها ، فضلاً عن زيادة الذكاء المالي للفرد"
		,"https://firebasestorage.googleapis.com/v0/b/bookstore-4337f.appspot.com/o/Rich%20Dad%20Poor%20Dad%D8%A7%D9%84%D8%A3%D8%A8%20%D8%A7%D9%84%D8%BA%D9%86%D9%8A%20%D9%88%D8%A7%D9%84%D8%A3%D8%A8%20%D8%A7%D9%84%D9%81%D9%82%D9%8A%D8%B1.webp?alt=media&token=0b6b052a-d9f0-430b-a6f4-e07f2fbc59fa"
		,2
		,new Date(1997,03,11)
		   ,new Date(2021-03-11)
		   ,nonFictionCatSet,
		2.4
		);
var  win_friends= new Book(
		"كيف تكسب الأصدقاء وتؤثر في الناس"
		,BigDecimal.valueOf(10)
		,"كيف تكسب الأصدقاء وتؤثر في الناس هو كتاب للمساعدة الذاتية كتبه ديل كارنيجي ونُشر في عام 1936. تم بيع أكثر من 30 مليون نسخة في جميع أنحاء العالم ، مما يجعله أحد الكتب الأكثر مبيعًا على الإطلاق. كان كارنيجي يجري دورات تعليم إدارة الأعمال في نيويورك منذ عام 1912."
		,"https://firebasestorage.googleapis.com/v0/b/bookstore-4337f.appspot.com/o/%D9%83%D9%8A%D9%81%20%D8%AA%D9%83%D8%B3%D8%A8%20%D8%A7%D9%84%D8%A3%D8%B5%D8%AF%D9%82%D8%A7%D8%A1%20%D9%88%D8%AA%D8%A4%D8%AB%D8%B1%20%D9%81%D9%8A%20%D8%A7%D9%84%D9%86%D8%A7%D8%B3.webp?alt=media&token=eec23daa-55dc-4af0-bf55-94907b7049af"
		,2
		   ,new Date(1936,03,11)
		   ,new Date(2021-03-11)
		   , Stream.concat(bestSellerCatSet.stream(), fictionCatSet.stream())
				   .collect(Collectors.toSet())

		,3.4
		);


		HashSet<Book> set2=new HashSet<>();
		set2.add(people);
	HashSet<Book> set3=new HashSet<>();
		set3.add(win_friends);

	HashSet<Book> set4=new HashSet<>();
		set4.add(Rich_Dad);

		List<Author> authors=new ArrayList<>();
		var author = new Author("روبرت كيوساكي",set4 );
		var Author1 = new Author("ديل كارنيجي",set3);
		var Author2 = new Author("ديل كارنيجي",set2);

		authors.add(author);
		authors.add(Author1);
		authors.add(Author2);


		authorRepo.saveAll(authors);




	}}
