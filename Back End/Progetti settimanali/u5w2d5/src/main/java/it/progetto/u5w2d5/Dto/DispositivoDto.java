package it.progetto.u5w2d5.Dto;

import it.progetto.u5w2d5.enums.StatoDispositivo;
import it.progetto.u5w2d5.enums.TipoDispositivo;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class DispositivoDto {
    @NotBlank
    @Size(max = 30, message = "La categoria non può superare i 15 caratteri")
    private String modello;

    @NotBlank(message = "Marca non può essere vuoto") // non puo essere vuoto
    @Size(max = 30, message = "La marca non può superare i 15 caratteri")
    private String marca;


    @NotNull
    private StatoDispositivo statoDispositivo;

    @NotNull
    private TipoDispositivo tipoDispositivo;

    @NotNull
    private int dipendenteId;
}
