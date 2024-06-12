package it.epicode.progetto_settimanale.gestione_eventi.Exceptions;

public class UserNotFoundException extends RuntimeException{
    public UserNotFoundException(String message){
    super(message);
    }
}
