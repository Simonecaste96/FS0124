package it.epicode.Security.JWT.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class UserLoginDto {

    @Email(message = "Inserire un email, il campo non può essere vuoto")
    @NotBlank
    private String email;

    @NotBlank(message = "Inserire la password")
    private String password;
}
