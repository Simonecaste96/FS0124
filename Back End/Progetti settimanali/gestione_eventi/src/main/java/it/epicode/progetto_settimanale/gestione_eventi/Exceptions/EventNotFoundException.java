package it.epicode.progetto_settimanale.gestione_eventi.Exceptions;

public class EventNotFoundException extends RuntimeException{
    public EventNotFoundException(String message){
        super(message);
    }
}
