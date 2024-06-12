package it.epicode.progetto_settimanale.gestione_eventi.Exceptions;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Error {
    private String messaggio;
    private LocalDateTime dataErrore;
}
