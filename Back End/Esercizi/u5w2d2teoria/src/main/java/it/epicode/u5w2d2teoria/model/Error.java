package it.epicode.u5w2d2teoria.model;

import lombok.Data;
import org.springframework.http.HttpStatus;


import java.time.LocalDateTime;

@Data
public class Error {
    private String messaggio;
    private LocalDateTime dataErrore;
}
