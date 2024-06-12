package it.epicode.epic_energy_services.Security;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import it.epicode.epic_energy_services.Exception.UnauthorizedException;
import it.epicode.epic_energy_services.entity.Cliente;
import it.epicode.epic_energy_services.entity.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class JwtTool {
    @Value("${jwt.secret}")
    private String secret;

    @Value("${jwt.duration}")
    private long duration;

    //ho implementato questa proprietà, ovviamente il token viene sovrascritto ogni volta che effettuo il login con un utente diverso
    // ma il problema sarà risolto con la parte front end salvando il token nel local storage, mi serve solo per acquistare il biglietto senza
    // dover identificare l'id del prenotatore
    private String userToken;

    // Metodo privato per impostare il token
    private synchronized void setUserToken(String userToken) {
        this.userToken = userToken;
    }

    // Metodo privato per ottenere il token
    public synchronized String getUserToken() {
        return userToken;
    }


    public String createToken(User user){

        String newToken = Jwts.builder().
                issuedAt(new Date(System.currentTimeMillis())).
                expiration(new Date(System.currentTimeMillis()+duration)).
                subject(String.valueOf(user.getId())).
                signWith(Keys.hmacShaKeyFor(secret.getBytes())).
                compact();


        setUserToken(newToken);
        System.out.println(newToken);

        return newToken;


    }





    public void verifyToken(String token){
        try{
            Jwts.parser().verifyWith(Keys.hmacShaKeyFor(secret.getBytes())).
                    build().parse(token);
        }

        catch (Exception e){
throw  new UnauthorizedException("Failed to authorize. Please login again to access this resource.");
        }
    }





    public int getIdFromToken(String token){
    return Integer.parseInt(Jwts.parser()
            .verifyWith(Keys.hmacShaKeyFor(secret.getBytes()))
            .build()
            .parseSignedClaims(token)
            .getPayload()
            .getSubject());
    }

}
