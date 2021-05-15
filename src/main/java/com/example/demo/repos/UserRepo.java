package com.example.demo.repos;

import com.example.demo.models.Author;
import com.example.demo.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface UserRepo extends JpaRepository<User,Long> {

    @Query("SELECT a FROM User a WHERE email =:email")
    Optional<User> findByEmail(@Param( "email" ) String email);
}
