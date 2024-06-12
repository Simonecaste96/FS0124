package it.epicode.progetto_settimanale.gestione_eventi.DTO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.time.LocalDate;

@Data
public class EventDTO {

    @NotBlank(message = "Il titolo non può essere vuoto")
    @Size(max = 30, message = "Il titolo dell'evento non può superare i 15 caratteri")
    private String title;

    @NotBlank(message = "La descrizione non può essere vuota") // non puo essere vuoto
    @Size(max = 50, message = "La marca non può superare i 15 caratteri")
    private String description;

    @NotNull(message = "La data non può essere vuota")
    private LocalDate date;

    @NotBlank(message = "Il luogo non può essere vuoto")
    private String place;

    @NotNull(message = "Obbligatorio inserire un numero massimo di partecipanti")
    private int numberMaxOfParticipants;


    private int eventManagerId;
}
