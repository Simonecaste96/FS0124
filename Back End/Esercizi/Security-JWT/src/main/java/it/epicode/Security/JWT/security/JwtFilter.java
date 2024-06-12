package it.epicode.Security.JWT.security;

import it.epicode.Security.JWT.exception.UnauthorizedException;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.AntPathMatcher;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
public class JwtFilter extends OncePerRequestFilter { // clicca su liena rossa, e poi implements method



    @Autowired
    private JwtTool jwtTool;


    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
    String authHeader = request.getHeader("Authorization");

        if (authHeader == null || !authHeader.startsWith("Bearer ")) {
            throw new UnauthorizedException("Error in authorization, token is null");
        }else{
            String token = authHeader.substring(7); // perche Bearer e spazio("Bearer ") occupano 7 caratteri, il token viene dopo!

            jwtTool.verifyToken(token); // controllo sempre la validità del token

            filterChain.doFilter(request,response);
        }

    }

    // se dovessero arrivare le richieste che hanno come path auth, non verranno bloccati
    @Override
    protected boolean shouldNotFilter(HttpServletRequest request) throws ServletException{
        return new AntPathMatcher().match("/auth/**",request.getServletPath());
    }

}
