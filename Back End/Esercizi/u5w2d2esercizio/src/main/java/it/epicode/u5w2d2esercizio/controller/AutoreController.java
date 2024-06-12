package it.epicode.u5w2d2esercizio.controller;

import it.epicode.u5w2d2esercizio.Dto.AutoreDto;
import it.epicode.u5w2d2esercizio.exception.AutoreNonTrovatoException;
import it.epicode.u5w2d2esercizio.exception.BadRequestException;
import it.epicode.u5w2d2esercizio.exception.BlogNonTrovatoException;
import it.epicode.u5w2d2esercizio.model.Autore;
import it.epicode.u5w2d2esercizio.service.AutoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;


import java.io.IOException;
import java.util.Map;
import java.util.Optional;

@RestController
public class AutoreController {
    @Autowired
    AutoreService autoreService;


    //ottengo la lista dei blog
    @GetMapping("/authors")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public Page<Autore> getListAuthors(@RequestParam(defaultValue = "0") int page,
                                       @RequestParam(defaultValue = "15") int size,
                                       @RequestParam(defaultValue = "id") String sortBy){
        return autoreService.getAllAutori(page,size,sortBy);// ricordati di aggiungere parametri per Pageable
    }

    //ricerco il blog per id
    @GetMapping("/authors/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public Autore getAuthorsById(@PathVariable int id)throws AutoreNonTrovatoException {
        Optional<Autore> authorBody = autoreService.getAutoreById(id);
        if(authorBody.isPresent()){
            return authorBody.get();
        }else{
            throw new AutoreNonTrovatoException("Nessun autore non trovato per il seguente id:"+ id);
        }
    }

    //creo il blog
    @PostMapping("/authors")
    @ResponseStatus(HttpStatus.CREATED)
    public String saveAuthor(@RequestBody @Validated AutoreDto autoreDto, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            throw new BadRequestException(bindingResult.getAllErrors().stream().
                    map(objectError -> objectError.getDefaultMessage()).reduce("", ((s, s2) -> s+s2)));
        }
        return autoreService.saveAutore(autoreDto);
    }

    //aggiorno il blog
    @PutMapping("/authors/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public Autore updateAuthor(@PathVariable int id,@RequestBody @Validated Autore autore,BindingResult bindingResult) throws AutoreNonTrovatoException{
        if(bindingResult.hasErrors()){
            throw new BadRequestException(bindingResult.getAllErrors().stream().
                    map(objectError -> objectError.getDefaultMessage()).reduce("", ((s, s2) -> s+s2)));
        }
        return autoreService.updateAutore(autore,id);
    }

    @PatchMapping("/updateInfo/authors/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public  Autore updateParseAuthor(@PathVariable int id,@RequestBody @Validated Map<String, Object> authorParse,BindingResult bindingResult) throws AutoreNonTrovatoException{
        if(bindingResult.hasErrors()){
            throw new BadRequestException(bindingResult.getAllErrors().stream().
                    map(objectError -> objectError.getDefaultMessage()).reduce("", ((s, s2) -> s+s2)));
        }
        return autoreService.updateAutoreParse(id,authorParse);
    }


    @PatchMapping("/updateAvatar/authors/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public  String updateAvatarCover(@PathVariable int id, @RequestBody  MultipartFile avatar) throws IOException {
        return autoreService.patchAvatarAutore(id,avatar);
    }

    @DeleteMapping("/authors/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public String deleteAuthor(@PathVariable int id)throws AutoreNonTrovatoException{
        return autoreService.deleteAutore(id);
    }
}
