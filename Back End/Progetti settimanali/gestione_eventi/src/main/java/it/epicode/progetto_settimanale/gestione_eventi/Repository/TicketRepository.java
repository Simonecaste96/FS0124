package it.epicode.progetto_settimanale.gestione_eventi.Repository;

import it.epicode.progetto_settimanale.gestione_eventi.Entities.Ticket;
import it.epicode.progetto_settimanale.gestione_eventi.Entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface TicketRepository extends JpaRepository<Ticket, UUID> {

}
