package it.progetto.u5w2d5.Dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class CellulareDto extends DispositivoDto{
    @NotBlank
    @Size(max = 10, message = "Il colore non può superare i 10 caratteri")
    private String colore;

    @NotNull(message = "Memoria GB non può essere vuota")
    private int memoriaGb;

}
