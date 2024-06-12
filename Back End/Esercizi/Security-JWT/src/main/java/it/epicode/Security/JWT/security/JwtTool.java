package it.epicode.Security.JWT.security;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import it.epicode.Security.JWT.entity.User;
import it.epicode.Security.JWT.exception.UnauthorizedException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Date;

@Component// classe gestita automaticamente da spring, stanziata in automatico in questo contesto
public class JwtTool {
    @Value("${jwt.secret}")
    private String secret;

    @Value("${jwt.duration}")
    private long duration;


    public String createToken(User user){
        //builder ci permette di inserire tutte le caratteristiche a cascata
        //issuedAt vuole per forza un oggetto DATE di vecchio tipo non LocalDate, sarà aggiornato?
        return Jwts.builder().
                issuedAt(new Date(System.currentTimeMillis())).//orario creazione token in millisecondi
                expiration(new Date(System.currentTimeMillis()+duration)).//orario scadenza token in millisecondi
                subject(String.valueOf(user.getId())). // utente a cui e associato questo token,prende l'id dal DATABASE
                signWith(Keys.hmacShaKeyFor(secret.getBytes())). // criptiamo il token in sha256
                compact(); // chiudiamo la firma del token, finalizzando il tutto
    }




    //verifica aggiuntiva pe controllare se il token precedentemente creato è stato alterato oppure no
    public void verifyToken(String token){
        try{
            Jwts.parser().verifyWith(Keys.hmacShaKeyFor(secret.getBytes())).
                    build().parse(token);
        }

        catch (Exception e){
throw  new UnauthorizedException("Failed to authorize. Please login again to access this resource.");
        }
    }
}
