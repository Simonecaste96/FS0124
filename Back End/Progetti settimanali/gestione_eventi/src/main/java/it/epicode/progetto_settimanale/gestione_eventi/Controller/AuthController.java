package it.epicode.progetto_settimanale.gestione_eventi.Controller;

import it.epicode.progetto_settimanale.gestione_eventi.DTO.UserDTO;
import it.epicode.progetto_settimanale.gestione_eventi.DTO.UserLoginDTO;
import it.epicode.progetto_settimanale.gestione_eventi.Exceptions.BadRequestException;
import it.epicode.progetto_settimanale.gestione_eventi.Service.AuthService;
import it.epicode.progetto_settimanale.gestione_eventi.Service.EventService;
import it.epicode.progetto_settimanale.gestione_eventi.Service.TicketService;
import it.epicode.progetto_settimanale.gestione_eventi.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    AuthService authService;

    @Autowired
    TicketService ticketService;

    @Autowired
    EventService eventService;

    @Autowired
    UserService userService;



    @PostMapping("/signup")
    public String signup(@RequestBody @Validated UserDTO userDTO, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            throw new BadRequestException(bindingResult.getAllErrors().stream().map(DefaultMessageSourceResolvable::getDefaultMessage).reduce("",(s, s2) -> s+s2 ));
        }

        return userService.saveUser(userDTO);
    }

    @PostMapping("/login")
    public String login(@RequestBody @Validated UserLoginDTO userLoginDTO, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            throw new BadRequestException(bindingResult.getAllErrors().stream().map(DefaultMessageSourceResolvable::getDefaultMessage).reduce("",(s, s2) -> s+s2 ));
        }

        return authService.authenticateUserAndCreateToken(userLoginDTO);
    }

}
