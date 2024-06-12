package it.epicode.progetto_settimanale.gestione_eventi.Entities;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.UUID;

@Data
@Entity
@Table(name = "tickets")
public class Ticket {

    @Id
    @GeneratedValue
    private UUID idBiglietto;

    private String eventTitle;

    private String bookerName;

    private String bookerSurname;

    private LocalDate eventDate;

    private LocalDate ticketIssueDate;


    @ManyToOne
    @JoinColumn(name = "prenotatore_id")
    private User userId;


    @ManyToOne
    @JoinColumn(name = "eventoPrenotatoId")
    private Event idEvento;


}
