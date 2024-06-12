package it.epicode.progetto_settimanale.gestione_eventi.DTO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.time.LocalDate;

@Data
public class TicketDTO {


    @NotNull
    private int eventId;

    @NotNull
    private int bookerId;

    private String bookerName;


    private String bookerSurname;


    private LocalDate ticketIssueDate;


    private LocalDate eventDate;

}
