package it.epicode.progetto_settimanale.gestione_eventi.Exceptions;

public class BadRequestException extends RuntimeException{
    public BadRequestException(String message){
        super(message);
    }
}
