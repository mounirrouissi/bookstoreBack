package com.example.demo.security;


import com.example.demo.providers.CustomProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;


@org.springframework.context.annotation.Configuration
public class Configuration extends WebSecurityConfigurerAdapter {
    @Autowired
    @Lazy
    private CustomProvider customProvider;


 /*   @Autowired
    private CustomFilter customFilter;
*/

    @Override
    @Bean
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }


    @Override
    protected void configure(AuthenticationManagerBuilder auth) {
        auth.authenticationProvider( customProvider );
    }


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.cors()
;        http.csrf().disable();
        http.authorizeRequests()
                .antMatchers("/login").permitAll();
//                .antMatchers("/authors").hasAnyAuthority("ADMIN")
//                .antMatchers("/books").hasAnyAuthority("USER")
////                .antMatchers("/delete/**").hasAuthority("ADMIN")
//                .anyRequest().authenticated()
//                .and()
//                .formLogin().successForwardUrl( "/authors" )
//                .and()
//                .logout().permitAll()
//                .logoutSuccessUrl( "/authors" )
//                .and()
//                .exceptionHandling().accessDeniedPage("/403");


    }
/*

    @Override
    protected void configure(HttpSecurity http) {
        http.addFilterBefore( customFilter, BasicAuthenticationFilter.class );

    }
*/



    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();

    }

}
