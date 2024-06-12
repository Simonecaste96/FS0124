package it.epicode.Security.JWT.controller;

import it.epicode.Security.JWT.dto.UserDto;
import it.epicode.Security.JWT.entity.User;
import it.epicode.Security.JWT.exception.BadRequestException;
import it.epicode.Security.JWT.exception.UserNotFoundException;
import it.epicode.Security.JWT.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController // annotazione base per i controller
@RequestMapping("/api")
public class UserController {

    @Autowired
    private UserService userService;



    @GetMapping("/users")
    public List<User> getAllUsers (){
        return userService.getAllUsers();
    }
    @GetMapping("/user/{id}")
    public User getUserById(@PathVariable int id){

        Optional<User> userOptional = userService.getUserById(id);

        if(userOptional.isPresent()){
            return userOptional.get();
        }else{
            throw new UserNotFoundException("User with id: "+id+"not found");
        }
    }

    @PutMapping("/user/{id}")
    public User updateUser(@PathVariable int id,@RequestBody @Validated UserDto userDto, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            throw new BadRequestException(bindingResult.getAllErrors().stream().map(e->e.getDefaultMessage()).reduce("",(s, s2) -> s+s2 ));
        }

        return userService.updateUser(id,userDto);
    }


    @DeleteMapping("/user/{id}")
    public String deleteUser(@PathVariable int id){
        return userService.deleteUser(id);
    }
}
