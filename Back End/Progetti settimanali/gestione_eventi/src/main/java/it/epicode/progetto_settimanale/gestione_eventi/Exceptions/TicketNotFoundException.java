package it.epicode.progetto_settimanale.gestione_eventi.Exceptions;

public class TicketNotFoundException extends RuntimeException{
    public TicketNotFoundException(String message){
    super(message);
    }
}
