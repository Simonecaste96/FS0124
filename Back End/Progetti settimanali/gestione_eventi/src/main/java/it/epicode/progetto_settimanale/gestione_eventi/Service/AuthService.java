package it.epicode.progetto_settimanale.gestione_eventi.Service;


import it.epicode.progetto_settimanale.gestione_eventi.DTO.UserLoginDTO;
import it.epicode.progetto_settimanale.gestione_eventi.Entities.User;
import it.epicode.progetto_settimanale.gestione_eventi.Exceptions.UnauthorizedException;
import it.epicode.progetto_settimanale.gestione_eventi.Security.JwtTool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {
    @Autowired
    private UserService userService;

    @Autowired
    private JwtTool jwtTool;


    @Autowired
    private PasswordEncoder passwordEncoder;


    public String authenticateUserAndCreateToken(UserLoginDTO userLoginDTO){
     User user = userService.getUserByEmail(userLoginDTO.getEmail());

        if (passwordEncoder.matches(userLoginDTO.getPassword() ,user.getPassword())) {
        return jwtTool.createToken(user); // metodo createToken vuole l'utente per cerare il token
        }else{
            throw  new UnauthorizedException("Dati errati, controllare i dati inseriti e prova nuovamente, se riscontri ancora problemi contatta l'assistenza di TicketGenius");
        }
    }


}
