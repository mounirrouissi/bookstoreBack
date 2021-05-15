/*
package com.example.demo.filters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@Component
public class CustomFilter extends UsernamePasswordAuthenticationFilter {
*/
/*
@Autowired
private AuthenticationManager authenticationManager;*//*

    @Override
    @Autowired
    public void setAuthenticationManager(AuthenticationManager authenticationManager) {
        super.setAuthenticationManager( authenticationManager );

    }

        @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
        UsernamePasswordAuthenticationToken authRequest = getAuthRequest(request);
        return this.getAuthenticationManager().authenticate(authRequest);
    }


    protected UsernamePasswordAuthenticationToken getAuthRequest(HttpServletRequest request) {
        var username=obtainUsername( request );
        var password=obtainPassword( request );
        return new UsernamePasswordAuthenticationToken(
                username, password);
    }


    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
var d=getAuthRequest( (HttpServletRequest) request );
var user=d.getPrincipal();
var pass=d.getCredentials();
    }


*/
/*
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        var username=obtainUsername( request );
        var password=obtainPassword( request );
        return new UsernamePasswordAuthenticationToken(
                username, password);
    }*//*

}
*/
