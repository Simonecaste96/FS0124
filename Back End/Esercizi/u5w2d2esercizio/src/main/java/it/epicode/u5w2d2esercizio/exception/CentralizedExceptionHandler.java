package it.epicode.u5w2d2esercizio.exception;

import it.epicode.u5w2d2esercizio.model.Error;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;

@RestControllerAdvice
public class CentralizedExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(BlogNonTrovatoException.class)
    public ResponseEntity<Object> BlogNonTrovatoHandler(BlogNonTrovatoException exception){
        Error error = new Error();
        error.setMessaggio(exception.getMessage());
        error.setDataErrore(LocalDateTime.now());
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(AutoreNonTrovatoException.class)
    public ResponseEntity<Object> AutoreNonTrovatoHandler(AutoreNonTrovatoException exception){
        Error error = new Error();
        error.setMessaggio(exception.getMessage());
        error.setDataErrore(LocalDateTime.now());
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<Object> BadRequestHandler (BadRequestException exception){
        Error error = new Error();
        error.setMessaggio(exception.getMessage());
        error.setDataErrore(LocalDateTime.now());
        return new ResponseEntity<>(error,HttpStatus.BAD_REQUEST);
    }
}
