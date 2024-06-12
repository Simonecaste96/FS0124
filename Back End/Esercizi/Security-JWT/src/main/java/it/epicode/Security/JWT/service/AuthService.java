package it.epicode.Security.JWT.service;

import it.epicode.Security.JWT.dto.UserLoginDto;
import it.epicode.Security.JWT.entity.User;
import it.epicode.Security.JWT.exception.UnauthorizedException;
import it.epicode.Security.JWT.security.JwtTool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthService {
    @Autowired
    private UserService userService;

    @Autowired
    private JwtTool jwtTool;

    //questo metodo verifica che esiste un utente con i dati inseriti per accedere corrispondono,
    //se l'utente esiste cede il token
    public String authenticateUserAndCreateToken(UserLoginDto userLoginDto){
     User user = userService.getUserByEmail(userLoginDto.getEmail());

        if (user.getPassword().equals(userLoginDto.getPassword())) { // se la password inserita corrisponde all'utente con questa email,crea il token, altrimenti eccezione
          return jwtTool.createToken(user); // metodo createToken vuole l'utente per cerare il token
        }else{
            throw  new UnauthorizedException("Failed to authorize. Please login again to access this resource.");
        }
    }
}
