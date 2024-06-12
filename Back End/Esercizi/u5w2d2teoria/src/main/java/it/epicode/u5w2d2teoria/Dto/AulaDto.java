package it.epicode.u5w2d2teoria.Dto;

import jakarta.validation.constraints.*;
import lombok.Data;

@Data
public class AulaDto {
    // !!!!***** NotEmpity incorpora la funzione di NotNull, NotBlack incorpora sia Empity che Null *****!!!!
   // @NotEmpty(message = "Il campo nome non può essere vuoto / ")
    @NotBlank(message = "Il campo non puo essere vuoto") //in campo non puo essere formato solo spazio vuoti
    //@NotNull // non puo essere inesistente
@Size(max = 30, message = "Il nome non puà superare i 30 caratteri") // massimo 30 caratteri // posso inserire dei messaggi!!
private String nome;

@Max(3)
@Min(0)
private int piano;
}
