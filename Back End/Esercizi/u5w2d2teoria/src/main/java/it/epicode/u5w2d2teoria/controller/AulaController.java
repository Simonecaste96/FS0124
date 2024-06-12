package it.epicode.u5w2d2teoria.controller;

import it.epicode.u5w2d2teoria.Dto.AulaDto;
import it.epicode.u5w2d2teoria.exception.AulaNonTrovataException;
import it.epicode.u5w2d2teoria.exception.BadRequestException;
import it.epicode.u5w2d2teoria.model.Aula;
import it.epicode.u5w2d2teoria.model.Studente;
import it.epicode.u5w2d2teoria.service.AulaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
//@RequestMapping("/api") questa annotazione serve per avere un path root in comune con tutti i path, senza scriverlo ogni volta
public class AulaController {
    @Autowired
    private AulaService aulaService;

    @PostMapping("/api/aule") // devo aggiungere @Validated dopo requestb body e l'oggetto BindingResult bindingResult
    public String saveAula(@RequestBody @Validated AulaDto aulaDto, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            throw new BadRequestException(bindingResult.getAllErrors().stream().
                    map(objectError -> objectError.getDefaultMessage()).reduce("", ((s, s2) -> s+s2)));
        }
        return aulaService.saveAula(aulaDto);
    }

    @GetMapping("/api/aule")
    public List<Aula> getListStudenti(){
        return aulaService.getAule();
    }

    @GetMapping("/api/aule/{id}")
    public Aula getAulaById(@PathVariable int id) throws AulaNonTrovataException {
        Optional<Aula> aulaOptional = aulaService.getAulaById(id);
        if(aulaOptional.isPresent()){
            return  aulaOptional.get();
        }else{
            throw  new AulaNonTrovataException("Non esiste nessuna aula con id: "+id);
        }
    }

@PutMapping("/api/aule/{id}")
    public Aula updateAula (@PathVariable int id, @RequestBody @Validated Aula aulaDto,BindingResult bindingResult){
    if(bindingResult.hasErrors()){
        throw new BadRequestException(bindingResult.getAllErrors().stream().
                map(objectError -> objectError.getDefaultMessage()).reduce("", ((s, s2) -> s+s2)));
    }
        return aulaService.updateAula(id,aulaDto);
    }


    @DeleteMapping("/api/aule/{id}")
    public String deleteAula(@PathVariable int id){
        return aulaService.deleteAula(id);
    }
}
