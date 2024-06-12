package it.progetto.u5w2d5.Dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class ComputerDto extends DispositivoDto{

    @NotNull(message = "Pollici monitor non può essere vuoto")
    private int polliciMonitor;

    @NotBlank
    @Size(max = 30, message = "Il nome della cpu non può superare i 30 caratteri")
    private String cpu;

    @NotNull(message = "Memoria GB non può essere vuota")
    private int gbRam;

}
