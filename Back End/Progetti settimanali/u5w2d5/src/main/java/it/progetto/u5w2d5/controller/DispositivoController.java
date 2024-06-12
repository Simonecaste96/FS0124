package it.progetto.u5w2d5.controller;

import it.progetto.u5w2d5.Dto.CellulareDto;
import it.progetto.u5w2d5.Dto.ComputerDto;
import it.progetto.u5w2d5.exception.BadRequestException;
import it.progetto.u5w2d5.exception.DispositivoNonTrovatoException;
import it.progetto.u5w2d5.model.Cellulare;
import it.progetto.u5w2d5.model.Computer;
import it.progetto.u5w2d5.model.Dispositivo;
import it.progetto.u5w2d5.service.CellulareService;
import it.progetto.u5w2d5.service.ComputerService;
import it.progetto.u5w2d5.service.DispositivoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


import java.util.Optional;

@RestController
@RequestMapping("/crud")
public class DispositivoController {


    @Autowired
    DispositivoService dispositivoService;
    @Autowired
    CellulareService cellulareService;

    @Autowired
    ComputerService computerService;


    // ho iniettato più di un service in modo da centralizzare le varie operazioni CRUD, senza dover fare un controller per ogni sottoclasse di Dispositivo,
    // in più ho sfruttato il polimorfismo ed ereditarietà, creando delle operazioni crud compatibili con vari dispositivi.


    //ottengo la lista dei dispositivi, metodo unico per tutti i dispositivi
    @GetMapping("/dispositivi")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public Page<Dispositivo> getListDispositivi(@RequestParam(defaultValue = "0") int page,
                                            @RequestParam(defaultValue = "15") int size,
                                            @RequestParam(defaultValue = "id") String sortBy){
        return dispositivoService.getDispositiviConPaginazione(page,size,sortBy);
    }


    //ottengo dispositivo per id, metodo unico per tutti i dispositivi
    @GetMapping("/dispositivo/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public Dispositivo getCellulareById(@PathVariable int id)throws DispositivoNonTrovatoException {
        Optional<Dispositivo> dispositivoOptional = dispositivoService.getDispositivoById(id);
        if(dispositivoOptional.isPresent()){
            return dispositivoOptional.get();
        }else{
            throw new DispositivoNonTrovatoException("Nessun dispositivo non trovato per il seguente id:"+ id);
        }
    }



    //creo il cellulare
    @PostMapping("/cellulare")
    @ResponseStatus(HttpStatus.CREATED)
    public String saveCellulare(@RequestBody @Validated CellulareDto cellulareDto, BindingResult bindingResult){
   if(bindingResult.hasErrors()){
       throw new BadRequestException(bindingResult.getAllErrors().stream().
               map(DefaultMessageSourceResolvable::getDefaultMessage).reduce("", ((s, s2) -> s+s2)));
   }
        return cellulareService.saveCellulare(cellulareDto);
    }

    //creo il computer
    @PostMapping("/computer")
    @ResponseStatus(HttpStatus.CREATED)
    public String saveComputer(@RequestBody @Validated ComputerDto computerDto, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            throw new BadRequestException(bindingResult.getAllErrors().stream().
                    map(DefaultMessageSourceResolvable::getDefaultMessage).reduce("", ((s, s2) -> s+s2)));
        }
        return computerService.saveComputer(computerDto);
    }



    //aggiorno il dispositivo
    @PutMapping("/cellulare/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public Cellulare updateCellulare(@PathVariable int id,@RequestBody @Validated CellulareDto cellulareDto,BindingResult bindingResult) throws DispositivoNonTrovatoException{
        if(bindingResult.hasErrors()){
            throw new BadRequestException(bindingResult.getAllErrors().stream().
                    map(DefaultMessageSourceResolvable::getDefaultMessage).reduce("", ((s, s2) -> s+s2)));
        }
        return cellulareService.updateCellulare(id,cellulareDto);
    }

    //aggiorno il dispositivo
    @PutMapping("/computer/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public Computer updateComputer(@PathVariable int id, @RequestBody @Validated ComputerDto computerDto, BindingResult bindingResult) throws DispositivoNonTrovatoException{
        if(bindingResult.hasErrors()){
            throw new BadRequestException(bindingResult.getAllErrors().stream().
                    map(DefaultMessageSourceResolvable::getDefaultMessage).reduce("", ((s, s2) -> s+s2)));
        }
        return computerService.updateComputer(id,computerDto);
    }




   // Anche qui uso dispositivoService, in modo da avere solo un delete uni per qualsiasi dispositivo!
@DeleteMapping("/dispositivo/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public String deleteDispositivo(@PathVariable int id)throws DispositivoNonTrovatoException{
        return dispositivoService.deleteDispositivo(id);
}

}
