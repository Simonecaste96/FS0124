package it.epicode.u5w2d2esercizio.Dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.time.Duration;
@Data
public class BlogDto {
    @NotBlank
    @Size(max = 15, message = "La categoria non può superare i 15 caratteri")
    private String categoria;

    @NotBlank(message = "Il titolo non può essere vuoto") // non puo essere vuoto
    @Size(max = 30, message = "Il cognome non puà superare i 30 caratteri")
    private String titolo;


    private String cover;

    @NotBlank(message = "Il contenuto non può essere vuoto") // non puo essere vuoto
    @Size(max = 300, message = "Il contenuto non può superare i 300 caratteri")
    private String contenuto;

    @NotNull
    private Long tempoDiLettura;

    @NotNull
    private int autoreId;
}
