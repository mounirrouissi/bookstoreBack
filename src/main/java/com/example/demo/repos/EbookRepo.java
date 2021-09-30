package com.example.demo.repos;

import com.example.demo.models.Ebook;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface EbookRepo extends JpaRepository<Ebook,Long> {
}
