package com.example.demo.providers;


import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class CustomProvider implements AuthenticationProvider {
    private UserDetailsService userDetailsService;
    private PasswordEncoder passwordEncoder;


    public CustomProvider(UserDetailsService userDetailsService, PasswordEncoder passwordEncoder) {
        this.userDetailsService = userDetailsService;
        this.passwordEncoder = passwordEncoder;
    }


    @Override
    public Authentication authenticate(Authentication authentication) throws CustomAuthenticationException {


        String username =authentication.getName();
        System.out.println("****username*****");
        System.out.println( username );
        String password= (String) authentication.getCredentials();
        System.out.println("*****password****");
        System.out.println( password );
        var u=userDetailsService.loadUserByUsername( username );
        System.out.println("****userds*****");
        System.out.println( u.getPassword()+"*******"+passwordEncoder.encode(  password) );
        if(passwordEncoder.matches(  password, u.getPassword())) {
            var a = new UsernamePasswordAuthenticationToken( username, password, null);
            System.out.println("*********");
            System.out.println( u.getAuthorities());
            return a;
        }
        //Auth Logic here

        //return :
             //null :unsupported
             //exception unAuth

        return null;
    }


    @Override
    public boolean supports(Class<?> authentication) {
        return UsernamePasswordAuthenticationToken.class.equals( authentication );
    }


}
