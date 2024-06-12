package it.epicode.progetto_settimanale.gestione_eventi.Exceptions;

public class SoldOutException extends RuntimeException{
    public SoldOutException(String message){
        super(message);
    }
}
