package it.epicode.u5w2d2esercizio.model;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Error {
    private String messaggio;
    private LocalDateTime dataErrore;
}
