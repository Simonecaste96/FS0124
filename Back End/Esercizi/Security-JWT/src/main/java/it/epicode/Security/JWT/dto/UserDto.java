package it.epicode.Security.JWT.dto;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

// IN DTO ANDIAMO ASD INSERIRE GLI UNICI DATI CHE VOGLIAMO FARCI PASSARE DAL CLIENT
//DAL MOMENTO CHE SI REGISTRA


@Data
public class UserDto {


    private String name;
    private String surname;

    @Email(message = "Inserire un email, il campo non può essere vuoto")
    @NotBlank
    private String email;

    @NotBlank(message = "Inserire la password")
    private String password;
}
