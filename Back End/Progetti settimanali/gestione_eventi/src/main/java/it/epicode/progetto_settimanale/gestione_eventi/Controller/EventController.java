package it.epicode.progetto_settimanale.gestione_eventi.Controller;

import it.epicode.progetto_settimanale.gestione_eventi.DTO.EventDTO;
import it.epicode.progetto_settimanale.gestione_eventi.DTO.UserDTO;
import it.epicode.progetto_settimanale.gestione_eventi.Entities.Event;
import it.epicode.progetto_settimanale.gestione_eventi.Exceptions.BadRequestException;
import it.epicode.progetto_settimanale.gestione_eventi.Exceptions.EventNotFoundException;
import it.epicode.progetto_settimanale.gestione_eventi.Service.AuthService;
import it.epicode.progetto_settimanale.gestione_eventi.Service.EventService;
import it.epicode.progetto_settimanale.gestione_eventi.Service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.context.support.DefaultMessageSourceResolvable;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class EventController {

    @Autowired
    EventService eventService;


    @PostMapping("/event")
    @PreAuthorize("hasAuthority('EVENT_MANAGER')")
    @ResponseStatus(HttpStatus.CREATED)
    public String createEvent(@RequestBody @Validated EventDTO eventDTO, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            throw new BadRequestException(bindingResult.getAllErrors().stream().map(DefaultMessageSourceResolvable::getDefaultMessage).collect(Collectors.joining()));
        }
        return eventService.saveEvent(eventDTO);
    }


    @GetMapping("/event")
    @PreAuthorize("hasAnyAuthority('EVENT_MANAGER','NORMAL_USER')")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public Page<Event> getListEvent(@RequestParam(defaultValue = "0") int page,
                                         @RequestParam(defaultValue = "15") int size,
                                         @RequestParam(defaultValue = "id") String sortBy){
        return eventService.getEventWithPagination(page,size,sortBy);
    }


    @GetMapping("/event/{id}")
    @PreAuthorize("hasAnyAuthority('EVENT_MANAGER', 'NORMAL_USER')")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public Event getEventById(@PathVariable int id)throws EventNotFoundException {
        Optional<Event> eventOptional = eventService.getEventById(id);
        if(eventOptional.isPresent()){
            return eventOptional.get();
        }else{
            throw new EventNotFoundException("Nessun evento trovato con id: "+ id);
        }
    }

    @GetMapping("/event/date/{date}")
    @PreAuthorize("hasAnyAuthority('EVENT_MANAGER', 'NORMAL_USER')")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public Event getEventByDate(@PathVariable LocalDate date)throws EventNotFoundException {
        Optional<Event> eventOptional = eventService.getEventByDate(date);
        if(eventOptional.isPresent()){
            return eventOptional.get();
        }else{
            throw new EventNotFoundException("Per adesso non ci sono eventi previsti in data: "+ date);
        }
    }




    @PutMapping("/event/{id}")
    @PreAuthorize("hasAuthority('EVENT_MANAGER')")
    @ResponseStatus(HttpStatus.CREATED)
    public Event updateEvent(@PathVariable int id, @RequestBody @Validated Event event, BindingResult bindingResult) throws EventNotFoundException {
        if(bindingResult.hasErrors()){
            throw new BadRequestException(bindingResult.getAllErrors().stream()
                    .map(objectError -> objectError.getDefaultMessage()).reduce("", ((s, s2) -> s + s2)));
        }
        return eventService.updateEvent(event, id);
    }
    @PatchMapping("/eventParse/{id}")
    @PreAuthorize("hasAuthority('EVENT_MANAGER')")
    @ResponseStatus(HttpStatus.CREATED)
    public Event updateParseEvent(@PathVariable int id, @RequestBody @Validated Map<String, Object> eventParse, BindingResult bindingResult) throws EventNotFoundException {
        if(bindingResult.hasErrors()){
            throw new BadRequestException(bindingResult.getAllErrors().stream()
                    .map(objectError -> objectError.getDefaultMessage()).reduce("", ((s, s2) -> s + s2)));
        }
        return eventService.updateEventParse(id, eventParse);
    }


    @DeleteMapping("/event/{id}")
    @PreAuthorize("hasAuthority('EVENT_MANAGER')")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public String deleteEvent(@PathVariable int id){
        return eventService.deleteEvent(id);
    }
}
