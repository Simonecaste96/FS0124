package it.epicode.progettoU5_W1_D5.beans;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;
import java.util.UUID;

@Data
@Entity
public class Biglietto {
@Id
@GeneratedValue
    private UUID idBiglietto;

    @OneToOne
    @JoinColumn(name = "prenotatore_id")
    private Utente utenteId;


    @ManyToOne
    @JoinColumn(name = "eventoPrenotatoId")
    private Prenotazione idEvento;


}
