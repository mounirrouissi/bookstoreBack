package com.example.demo.security.services;

import com.example.demo.models.Author;
import com.example.demo.models.User;
import com.example.demo.repos.AuthorRepo;
import com.example.demo.repos.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    private UserRepo userRepo;




    public UserDetailsServiceImpl() {
    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        System.out.println(username);
        User user = userRepo
              .findByEmail( username )
                .orElseThrow( () -> new UsernameNotFoundException( this.getClass().getSimpleName()+"said username not found!!!" ) );

        return new MyUserDetails( user );
    }
}
