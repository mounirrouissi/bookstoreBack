package com.example.demo.filters;/*package com.example.demo.filters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.stereotype.Component;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class CustomFilter extends UsernamePasswordAuthenticationFilter {


private  AuthenticationManager authenticationManager ;
    @Override
    @Autowired
    public void setAuthenticationManager(AuthenticationManager authenticationManager) {
        super.setAuthenticationManager(authenticationManager);
    }

    protected UsernamePasswordAuthenticationToken getAuthRequest(HttpServletRequest request) {
        var username=obtainUsername( request );
        System.out.println("*********");
        System.out.println(username);
        System.out.println("*********");
        var password=obtainPassword( request );
        return new UsernamePasswordAuthenticationToken(
                username, password);
    }


    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
UsernamePasswordAuthenticationToken authRequest = getAuthRequest( (HttpServletRequest) request );
this.authenticationManager.authenticate( authRequest );

    }*/
