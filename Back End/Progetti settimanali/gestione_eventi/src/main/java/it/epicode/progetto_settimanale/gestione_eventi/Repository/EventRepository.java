package it.epicode.progetto_settimanale.gestione_eventi.Repository;

import it.epicode.progetto_settimanale.gestione_eventi.Entities.Event;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.Optional;

public interface EventRepository extends JpaRepository<Event,Integer> {

    public Optional<Event> findByDate(LocalDate date);
}
