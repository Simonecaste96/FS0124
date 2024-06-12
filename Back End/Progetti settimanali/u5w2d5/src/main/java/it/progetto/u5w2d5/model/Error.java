package it.progetto.u5w2d5.model;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Error {
    private String messaggio;
    private LocalDateTime dataErrore;
}
