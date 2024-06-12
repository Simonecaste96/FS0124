package it.epicode.progetto_settimanale.gestione_eventi.Exceptions;

public class UnauthorizedException extends RuntimeException{
    public UnauthorizedException(String message){
        super(message);
    }
}
