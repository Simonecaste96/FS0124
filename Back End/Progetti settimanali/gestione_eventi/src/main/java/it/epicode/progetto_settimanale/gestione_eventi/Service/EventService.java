package it.epicode.progetto_settimanale.gestione_eventi.Service;

import it.epicode.progetto_settimanale.gestione_eventi.DTO.EventDTO;
import it.epicode.progetto_settimanale.gestione_eventi.Entities.Event;
import it.epicode.progetto_settimanale.gestione_eventi.Entities.User;
import it.epicode.progetto_settimanale.gestione_eventi.Exceptions.BadRequestException;
import it.epicode.progetto_settimanale.gestione_eventi.Exceptions.EventNotFoundException;
import it.epicode.progetto_settimanale.gestione_eventi.Exceptions.NotFoundException;
import it.epicode.progetto_settimanale.gestione_eventi.Exceptions.UserNotFoundException;
import it.epicode.progetto_settimanale.gestione_eventi.Repository.EventRepository;
import it.epicode.progetto_settimanale.gestione_eventi.Repository.TicketRepository;
import it.epicode.progetto_settimanale.gestione_eventi.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class EventService {

    @Autowired
    EventRepository eventRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    TicketRepository ticketRepository;

    @Autowired
    private JavaMailSenderImpl javaMailSenderImpl;

    public Optional<Event> getEventByDate(LocalDate date){
       return eventRepository.findByDate(date);

    }



    public Optional<Event> getEventById(int id){
        return eventRepository.findById(id);
    }


    public Page<Event> getEventWithPagination(int page, int size, String sortBy){
        Pageable pageable = PageRequest.of(page,size, Sort.by(sortBy));
        return  eventRepository.findAll(pageable);
    }
    public List<Event> getEvents(){
        return  eventRepository.findAll();
    }



    public String saveEvent(EventDTO eventDTO) {
        Optional<Event> eventOptional = eventRepository.findByDate(eventDTO.getDate());

        if (eventOptional.isPresent()) {
            boolean eventPlaceOptional = eventOptional.stream()
                    .anyMatch(e -> e.getPlace().equals(eventDTO.getPlace()));

            if (eventPlaceOptional) {
                throw new BadRequestException("È già previsto un evento con in data: " + eventDTO.getDate() + ", presso: " + eventDTO.getPlace());
            }
        }


        Optional<User> userOptional = userRepository.findById(eventDTO.getEventManagerId());
        if (userOptional.isPresent()) {
            System.out.println("Ciao "+userOptional.get().getName()+", l'evento sta per essere creato!");
            Event event = new Event();
            event.setTitle(eventDTO.getTitle());
            event.setDescription(eventDTO.getDescription());
            event.setPlace(eventDTO.getPlace());
            event.setDate(eventDTO.getDate());
            event.setNumberMaxOfParticipants(eventDTO.getNumberMaxOfParticipants());
            event.setEventManager(userOptional.get());

            eventRepository.save(event);
            sendMailEventCreated(event.getEventManager().getEmail());

            return "Perfetto "+userOptional.get().getName()+"!"+" L'evento è stato aggiunto, l'id è: " + event.getId() + ", titolo: " + event.getTitle();

        }
        throw new BadRequestException("Gestore dell'evento non trovato con ID: " + eventDTO.getEventManagerId());

    }

    public Event updateEvent(Event eventUpdate, int id) throws EventNotFoundException {
        Optional<Event> eventOptional = getEventById(id);
        if (eventOptional.isPresent()) {
            Event event = eventOptional.get();
            event.setTitle(eventUpdate.getTitle());
            event.setDescription(eventUpdate.getDescription());
            event.setPlace(eventUpdate.getPlace());
            event.setDate(eventUpdate.getDate());

            return eventRepository.save(event);
        } else {
            throw new UserNotFoundException("Non risulta nessun evento con il seguente id: "+ id);
        }
    }


    public Event updateEventParse(int id, Map<String, Object> update) throws EventNotFoundException {
        Optional<Event> userOpt = getEventById(id);
        if (userOpt.isPresent()) {
            Event event = userOpt.get();

            update.forEach((key, value) -> {
                switch (key) {
                    case "title":
                        event.setTitle((String) value);
                        break;
                    case "description":
                        event.setDescription((String) value);
                        break;
                    case "place":
                        event.setPlace((String) value);
                        break;
                    case "date":
                        event.setDate(LocalDate.parse((String) value));
                        break;

                    default:
                        throw new IllegalArgumentException("Campo non valido: " + key);
                }
            });

            eventRepository.save(event);

            return event;
        } else {
            throw new UserNotFoundException("Nessun utente trovato con id: " + id);
        }
    }



    public String deleteEvent(int id) throws EventNotFoundException {
        Optional<Event> eventOptional = getEventById(id);

        if (eventOptional.isPresent()) {

            Event event = eventOptional.get();

            // prendo tutti i biglietti di quell'evento e li cancello
            List<UUID> ticketIds =  event.getListaBiglietti().stream().map(e->e.getIdBiglietto()).collect(Collectors.toList());
            ticketRepository.deleteAllByIdInBatch(ticketIds);

            //cancello l'evento
            eventRepository.delete(eventOptional.get());

            //invio mail di conferma all'organizzatore
            sendMailEventDelete(event.getEventManager().getEmail());

            // io email anche a chi ha prenotato l'evento, per avvertirlo
            event.getListaBiglietti().stream().map(e->e.getUserId().getEmail()).forEach(this::sendMailEventDeleteToBooker);




            return "Evento con id: "+ id + " eliminato dal database";
        } else {
            throw new EventNotFoundException("Nessun evento trovato con id: "+id);
        }


    }

    private void sendMailEventCreated(String email) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(email);
        message.setSubject("TicketGenius: Evento creato!");
        message.setText("Evento creato ed aggiunto correttamente, ora bisogna solo aspettare il grande giorno, nel frattempo le prenotazioni sono aperte!");

        javaMailSenderImpl.send(message);
    }

    private void sendMailEventDelete(String email) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(email);
        message.setSubject("TicketGenius: Evento annullato...");
        message.setText("Evento annullato, ci dispiace molto, ma ricorda che noi siamo sempre qui!");

        javaMailSenderImpl.send(message);
    }

    private void sendMailEventDeleteToBooker(String email) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(email);
        message.setSubject("TicketGenius: Evento annullato...");
        message.setText("Ci dispiace comunicarti che l'evento è stato annullato, ci dispiace molto, riceverai il rimborso entro 5-6 giorni, TicketGenius ti aspetta nuovamente e ti regala un 15% di buono sul tuo prossimo acquisto!");

        javaMailSenderImpl.send(message);
    }
}
