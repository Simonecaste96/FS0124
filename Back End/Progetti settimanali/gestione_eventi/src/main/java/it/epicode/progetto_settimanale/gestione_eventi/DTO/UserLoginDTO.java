package it.epicode.progetto_settimanale.gestione_eventi.DTO;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class UserLoginDTO {

    @Email(message = "Inserire l'email")
    @NotBlank
    private String email;

    @NotBlank(message = "Inserire la password")
    private String password;
}
