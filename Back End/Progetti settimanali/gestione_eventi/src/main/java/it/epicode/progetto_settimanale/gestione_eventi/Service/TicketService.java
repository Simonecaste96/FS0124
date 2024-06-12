package it.epicode.progetto_settimanale.gestione_eventi.Service;



import it.epicode.progetto_settimanale.gestione_eventi.DTO.TicketDTO;
import it.epicode.progetto_settimanale.gestione_eventi.Entities.Event;
import it.epicode.progetto_settimanale.gestione_eventi.Entities.Ticket;
import it.epicode.progetto_settimanale.gestione_eventi.Entities.User;
import it.epicode.progetto_settimanale.gestione_eventi.Exceptions.*;
import it.epicode.progetto_settimanale.gestione_eventi.Repository.EventRepository;
import it.epicode.progetto_settimanale.gestione_eventi.Repository.TicketRepository;
import it.epicode.progetto_settimanale.gestione_eventi.Repository.UserRepository;
import it.epicode.progetto_settimanale.gestione_eventi.Security.JwtTool;
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
import java.util.Optional;
import java.util.UUID;

@Service
public class TicketService {

    @Autowired
    private JavaMailSenderImpl javaMailSenderImpl;
    @Autowired
    TicketRepository ticketRepository;

    @Autowired
    EventRepository eventRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    JwtTool jwtTool;

    public Page<Ticket> getTicketWithPagination(int page, int size, String sortBy){
        Pageable pageable = PageRequest.of(page,size, Sort.by(sortBy));
        return  ticketRepository.findAll(pageable);
    }

    public List<Ticket> getTickets(){
        return  ticketRepository.findAll();
    }

    public Optional<Ticket> getTicketById(UUID idTicket){
        return ticketRepository.findById(idTicket);
    }

   /* public String saveTicket(TicketDTO ticketDTO) {
        Optional<Event> eventOptional = eventRepository.findById(ticketDTO.getEventId());
        Optional<User> userOptional = userRepository.findById(jwtTool.getIdFromToken(jwtTool.getUserToken()));

        if (eventOptional.isPresent()) {
            Event event = eventOptional.get();

            if (event.getListaBiglietti().size() < event.getNumberMaxOfParticipants()) {
                Ticket ticket = new Ticket();
if(ticketDTO.getBookerName().isEmpty() && ticketDTO.getBookerSurname().isEmpty()){
    ticket.setBookerName(ticketDTO.getBookerName());
    ticket.setBookerSurname(ticketDTO.getBookerSurname());
}
                ticket.setBookerName(userOptional.get().getName());
                ticket.setBookerSurname((userOptional.get().getSurname()));
                ticket.setEventDate(eventOptional.get().getDate());
                ticket.setTicketIssueDate(LocalDate.now());
                ticket.setEventTitle(eventOptional.get().getTitle());
                ticket.setUserId(userOptional.get());

                ticket.setIdEvento(event);

                // associo l'id dell'utente che ha effettuato il login in modo da associargli il biglietto
                ticketDTO.setBookerId(userOptional.get().getId());

                ticketRepository.save(ticket);

                return "Biglietto creato correttamente";
            } else {
                return "*****EVENTO SOLD OUT****";
            }
        } else {
            throw new EventNotFoundException("Nessun evento trovato con l'id: " + ticketDTO.getEventId());
        }
    }*/public String saveTicket(TicketDTO ticketDTO) {
       Optional<Event> eventOptional = eventRepository.findById(ticketDTO.getEventId());
       Optional<User> userOptional = userRepository.findById(jwtTool.getIdFromToken(jwtTool.getUserToken()));

       if (eventOptional.isPresent()) {
           Event event = eventOptional.get();

           if (event.getListaBiglietti().size() < event.getNumberMaxOfParticipants()) {
               if (userOptional.isPresent()) {
                   User user = userOptional.get();
                   Ticket ticket = new Ticket();

                   // se inserisco dettagli del prenotatore li uso, altrimenti usa i dettagli dell'utente loggato

                   if (ticketDTO.getBookerName() != null && !ticketDTO.getBookerName().isEmpty() &&
                           ticketDTO.getBookerSurname() != null && !ticketDTO.getBookerSurname().isEmpty()) {
                       ticket.setBookerName(ticketDTO.getBookerName());
                       ticket.setBookerSurname(ticketDTO.getBookerSurname());
                   } else {
                       ticket.setBookerName(user.getName());
                       ticket.setBookerSurname(user.getSurname());
                   }

                   ticket.setEventDate(event.getDate());
                   ticket.setTicketIssueDate(LocalDate.now());
                   ticket.setEventTitle(event.getTitle());
                   ticket.setUserId(user);
                   ticket.setIdEvento(event);

                   // Associa l'id dell'utente che ha effettuato il login in modo da associargli il biglietto
                   ticketDTO.setBookerId(user.getId());

                   ticketRepository.save(ticket);

                   return "Biglietto creato correttamente";
               } else {
                   return "Errore: utente non trovato";
               }
           } else {
               return "*****EVENTO SOLD OUT****";
           }
       } else {
           throw new EventNotFoundException("Nessun evento trovato con l'id: " + ticketDTO.getEventId());
       }
   }






    public Ticket updateTicket(Ticket ticketUpdate, UUID idTicket) throws TicketNotFoundException {
        Optional<Ticket> ticketOptional = ticketRepository.findById(idTicket);
        if (ticketOptional.isPresent()) {
            Ticket ticket = ticketOptional.get();
            ticket.setBookerName(ticketUpdate.getBookerName());
            ticket.setBookerSurname(ticketUpdate.getBookerSurname());
            return ticketRepository.save(ticket);
        } else {
            throw new UserNotFoundException("Non risulta nessun evento con il seguente id: "+ idTicket);
        }
    }




    public String deleteTicket(UUID idTicket) throws TicketNotFoundException {
        Optional<Ticket> ticketOptional = ticketRepository.findById(idTicket);

        if (ticketOptional.isPresent()) {

            Ticket ticket = ticketOptional.get();

            ticketRepository.delete(ticket);

            sendMailTicketDelete(ticketOptional.get().getUserId().getEmail());

            return "Biglietto annullato";
        } else {
            throw new EventNotFoundException("Nessun evento biglietto con id: "+idTicket);
        }


    }


    private void sendMailTicketDelete(String email) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(email);
        message.setSubject("TicketGenius: Evento annullato...");
        message.setText("Evento annullato, ci dispiace molto, ma ricorda che noi siamo sempre qui!");

        javaMailSenderImpl.send(message);
    }
}
