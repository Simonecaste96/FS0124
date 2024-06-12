package it.epicode.Security.JWT.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class ConfigSecurity {

    //disabilitiamo alcuni filtri, tipo l'autenticazione con il form, csrf(protezione contro accessi impropri), sessionManagement
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.formLogin(e->e.disable()); // SENZA FRONT END SI BLOCCA
        httpSecurity.csrf(e->e.disable());
        httpSecurity.sessionManagement(e->e.sessionCreationPolicy(SessionCreationPolicy.STATELESS)); // SENZA FRONT END SI BLOCCA

     httpSecurity.authorizeHttpRequests(e->e.requestMatchers("/**").permitAll()); // permette a tutti di accedere a tutti i path
    return httpSecurity.build();
    };


}
