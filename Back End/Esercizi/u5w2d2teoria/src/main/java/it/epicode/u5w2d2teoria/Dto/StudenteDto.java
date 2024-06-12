package it.epicode.u5w2d2teoria.Dto;

import jakarta.validation.constraints.*;
import lombok.Data;

import java.time.LocalDate;

@Data
public class StudenteDto {

    //@NotEmpty(message = "Il campo nome non può essere vuoto")
    @NotBlank //in campo non puo solo spazio vuoti
    //@NotNull // non puo essere inesistente
    @Size(max = 30, message = "Il nome non puà superare i 30 caratteri")
    private String nome;

    @NotNull(message = "Il campo cognome non può essere vuoto") // non puo essere vuoto
    @Size(max = 30, message = "Il cognome non puà superare i 30 caratteri")
    private String cognome;

    @NotNull(message = "Il data di nascita nome non può essere vuoto") // non puo essere vuoto
    private LocalDate dataNascita;


    @Email
    @NotNull
    private String email;

    @NotNull(message = "Il id nome non può essere vuoto") // non puo essere vuoto
    private int aulaId;

}
