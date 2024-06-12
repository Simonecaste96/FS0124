package it.epicode.progetto_settimanale.gestione_eventi.Controller;

import it.epicode.progetto_settimanale.gestione_eventi.DTO.EventDTO;
import it.epicode.progetto_settimanale.gestione_eventi.DTO.TicketDTO;
import it.epicode.progetto_settimanale.gestione_eventi.Entities.Ticket;
import it.epicode.progetto_settimanale.gestione_eventi.Exceptions.BadRequestException;
import it.epicode.progetto_settimanale.gestione_eventi.Exceptions.TicketNotFoundException;
import it.epicode.progetto_settimanale.gestione_eventi.Service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class TicketController {

    @Autowired
    TicketService ticketService;


    @PostMapping("/ticket")
    @ResponseStatus(HttpStatus.CREATED)
    public String createTicket(@RequestBody @Validated TicketDTO ticketDTO, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            throw new BadRequestException(bindingResult.getAllErrors().stream().map(DefaultMessageSourceResolvable::getDefaultMessage).collect(Collectors.joining()));
        }
        return ticketService.saveTicket(ticketDTO);
    }


    @GetMapping("/tickets")
    @PreAuthorize("hasAuthority('EVENT_MANAGER')")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public Page<Ticket> getListTickets(@RequestParam(defaultValue = "0") int page,
                                       @RequestParam(defaultValue = "15") int size,
                                       @RequestParam(defaultValue = "id") String sortBy){
        return ticketService.getTicketWithPagination(page,size,sortBy);
    }


    @GetMapping("/ticket/{idTicket}")
    @PreAuthorize("hasAnyAuthority('EVENT_MANAGER')")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public Ticket getTicketById(@PathVariable UUID idTicket) throws TicketNotFoundException {
        Optional<Ticket> ticketOptional = ticketService.getTicketById(idTicket);
        if(ticketOptional.isPresent()){
            return ticketOptional.get();
        } else {
            throw new TicketNotFoundException("Nessun ticket trovato con id: " + idTicket);
        }
    }


    @PutMapping("/ticket/{idTicket}")
    @PreAuthorize("hasAuthority('EVENT_MANAGER')")
    @ResponseStatus(HttpStatus.CREATED)
    public Ticket updateTicket(@PathVariable UUID idTicket, @RequestBody @Validated Ticket ticket, BindingResult bindingResult) throws TicketNotFoundException {
        if(bindingResult.hasErrors()){
            throw new BadRequestException(bindingResult.getAllErrors().stream()
                    .map(objectError -> objectError.getDefaultMessage()).reduce("", ((s, s2) -> s + s2)));
        }
        return ticketService.updateTicket(ticket, idTicket);
    }



    @DeleteMapping("/ticket/{idTicket}")
    @PreAuthorize("hasAnyAuthority('EVENT_MANAGER','NORMAL_USER')")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public String deleteTicket(@PathVariable UUID idTicket)throws TicketNotFoundException{
        return ticketService.deleteTicket(idTicket);
    }
}
