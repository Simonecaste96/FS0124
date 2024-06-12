package it.epicode.Security.JWT.controller;

import it.epicode.Security.JWT.dto.UserDto;
import it.epicode.Security.JWT.dto.UserLoginDto;
import it.epicode.Security.JWT.exception.BadRequestException;
import it.epicode.Security.JWT.service.AuthService;
import it.epicode.Security.JWT.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {
    @Autowired
    private AuthService authService;
    @Autowired
    private UserService userService;


    //end point registrazione
    @PostMapping("/signup")
    public String signup(@RequestBody @Validated UserDto userDto, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            throw new BadRequestException(bindingResult.getAllErrors().stream().map(e->e.getDefaultMessage()).reduce("",(s, s2) -> s+s2 ));
        }

        return userService.saveUser(userDto);
    }


    // end point login
    @PostMapping("/login")
    public String login(@RequestBody @Validated UserLoginDto userLoginDto, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            throw new BadRequestException(bindingResult.getAllErrors().stream().map(e->e.getDefaultMessage()).reduce("",(s, s2) -> s+s2 ));
        }

        return authService.authenticateUserAndCreateToken(userLoginDto);
    }

}
