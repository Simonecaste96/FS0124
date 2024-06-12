package it.progetto.u5w2d5.controller;


import it.progetto.u5w2d5.Dto.DipendenteDto;
import it.progetto.u5w2d5.exception.BadRequestException;
import it.progetto.u5w2d5.exception.DipendenteNonTrovatoException;
import it.progetto.u5w2d5.model.Dipendente;
import it.progetto.u5w2d5.service.DipendenteService;
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
@RequestMapping("/crud")
public class DipendenteController {
    @Autowired
    DipendenteService dipendenteService;



    @GetMapping("/dipendenti")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public Page<Dipendente> getListDipendenti(@RequestParam(defaultValue = "0") int page,
                                           @RequestParam(defaultValue = "15") int size,
                                           @RequestParam(defaultValue = "id") String sortBy){
        return dipendenteService.getDipendentiConPaginazione(page,size,sortBy);
    }


    @GetMapping("/dipendente/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public Dipendente getDipendenteById(@PathVariable int id)throws DipendenteNonTrovatoException {
        Optional<Dipendente> dipendenteOptional = dipendenteService.getDipendenteById(id);
        if(dipendenteOptional.isPresent()){
            return dipendenteOptional.get();
        }else{
            throw new DipendenteNonTrovatoException("Nessun dipendente trovato con matricola: "+ id);
        }
    }

    //creo il blog
    @PostMapping("/dipendente")
    @ResponseStatus(HttpStatus.CREATED)
    public String saveDipendente(@RequestBody @Validated DipendenteDto dipendenteDto, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            throw new BadRequestException(bindingResult.getAllErrors().stream().
                    map(objectError -> objectError.getDefaultMessage()).reduce("", ((s, s2) -> s+s2)));
        }
        return dipendenteService.saveDipendente(dipendenteDto);
    }

    //aggiorno il blog
    @PutMapping("/dipendente/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public Dipendente updateDipendente(@PathVariable int id,@RequestBody @Validated Dipendente dipendente,BindingResult bindingResult) throws DipendenteNonTrovatoException{
        if(bindingResult.hasErrors()){
            throw new BadRequestException(bindingResult.getAllErrors().stream().
                    map(objectError -> objectError.getDefaultMessage()).reduce("", ((s, s2) -> s+s2)));
        }
        return dipendenteService.updateDipendente(dipendente,id);
    }

    @PatchMapping("/dipendenteParse/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public  Dipendente updateParseDipendente(@PathVariable int id,@RequestBody @Validated Map<String, Object> dipendenteParse,BindingResult bindingResult) throws DipendenteNonTrovatoException{
        if(bindingResult.hasErrors()){
            throw new BadRequestException(bindingResult.getAllErrors().stream().
                    map(objectError -> objectError.getDefaultMessage()).reduce("", ((s, s2) -> s+s2)));
        }
        return dipendenteService.updateDipendenteParse(id,dipendenteParse);
    }


    @PatchMapping("/updateFoto/dipendente/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public  String updateImmagineProfilo(@PathVariable int id, @RequestBody  MultipartFile foto) throws IOException {
        return dipendenteService.patchImmagineProfiloDipendente(id,foto);
    }

    @DeleteMapping("/dipendente/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public String deleteDipendente(@PathVariable int id)throws DipendenteNonTrovatoException{
        return dipendenteService.deleteDipendente(id);
    }
}
