package com.example.demo.service;

import com.example.demo.models.Book;
import com.example.demo.repos.BookRepo;
import com.example.demo.repos.ProductCategoryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
public class CategoryService {


    @Autowired
    private ProductCategoryRepo categoryRepo;



}
