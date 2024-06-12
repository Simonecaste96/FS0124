package it.epicode.progetto_settimanale.gestione_eventi.Entities;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
@Entity
@Table(name = "events")
public class Event {

    @Id
    @GeneratedValue
    private int id;


    private String title;

    private String description;

    private LocalDate date;

    private String place;

    private int numberMaxOfParticipants;



    @OneToMany(mappedBy = "idEvento")
    @JsonIgnore
    private List<Ticket> listaBiglietti;


    @ManyToOne
    @JoinColumn(name = "event_manager_id")
    @JsonIgnore
    private  User eventManager;
}
