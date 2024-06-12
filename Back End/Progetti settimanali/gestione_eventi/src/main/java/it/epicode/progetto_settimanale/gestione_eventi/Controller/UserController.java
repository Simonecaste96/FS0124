package it.epicode.progetto_settimanale.gestione_eventi.Controller;

import it.epicode.progetto_settimanale.gestione_eventi.DTO.EventDTO;
import it.epicode.progetto_settimanale.gestione_eventi.Entities.User;
import it.epicode.progetto_settimanale.gestione_eventi.Exceptions.BadRequestException;
import it.epicode.progetto_settimanale.gestione_eventi.Exceptions.UserNotFoundException;
import it.epicode.progetto_settimanale.gestione_eventi.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    UserService userService;



    @GetMapping("/users")
    @PreAuthorize("hasAuthority('EVENT_MANAGER')")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public Page<User> getListUsers(@RequestParam(defaultValue = "0") int page,
                                   @RequestParam(defaultValue = "15") int size,
                                   @RequestParam(defaultValue = "id") String sortBy){
        return userService.getUserConPaginazione(page,size,sortBy);
    }


    @GetMapping("/user/{id}")
    @PreAuthorize("hasAnyAuthority('EVENT_MANAGER)")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public User getUserById(@PathVariable int id)throws UserNotFoundException {
        Optional<User> userOptional = userService.getUserById(id);
        if(userOptional.isPresent()){
            return userOptional.get();
        }else{
            throw new UserNotFoundException("Nessun dipendente trovato con matricola: "+ id);
        }
    }




    @PutMapping("/user/{id}")
    @PreAuthorize("hasAuthority('EVENT_MANAGER','NORMAL_USER')")
    @ResponseStatus(HttpStatus.CREATED)
    public User updateUser(@PathVariable int id, @RequestBody @Validated User user, BindingResult bindingResult) throws UserNotFoundException{
        if(bindingResult.hasErrors()){
            throw new BadRequestException(bindingResult.getAllErrors().stream().
                    map(objectError -> objectError.getDefaultMessage()).reduce("", ((s, s2) -> s+s2)));
        }
        return userService.updateUser(user,id);
    }

    @PatchMapping("/userParse/{id}")
    @PreAuthorize("hasAuthority('EVENT_MANAGER','NORMAL_USER')")
    @ResponseStatus(HttpStatus.CREATED)
    public  User updateParseUser(@PathVariable int id, @RequestBody @Validated Map<String, Object> dipendenteParse, BindingResult bindingResult) throws UserNotFoundException{
        if(bindingResult.hasErrors()){
            throw new BadRequestException(bindingResult.getAllErrors().stream().
                    map(objectError -> objectError.getDefaultMessage()).reduce("", ((s, s2) -> s+s2)));
        }
        return userService.updateUserParse(id,dipendenteParse);
    }


    @PatchMapping("/updateFoto/user/{id}")
    @PreAuthorize("hasAnyAuthority('EVENT_MANAGER', 'NORMAL_USER')")
    @ResponseStatus(HttpStatus.CREATED)
    public  String updateImmagineProfilo(@PathVariable int id, @RequestBody MultipartFile foto) throws IOException {
        return userService.patchPictureProfileUser(id,foto);
    }

    @DeleteMapping("/user/{id}")
    @PreAuthorize("hasAuthority('EVENT_MANAGER,'USER')")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public String deleteUser(@PathVariable int id)throws UserNotFoundException{
        return userService.deleteUser(id);
    }
}
