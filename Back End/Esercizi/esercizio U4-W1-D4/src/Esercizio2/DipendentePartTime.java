package Esercizio2;

public class DipendentePartTime extends Dipendente {

    private double stipendioMensile;
    public DipendentePartTime(String matricola, int stipendio, String dipartimento ,double stipendioMensile ){
        super(matricola,stipendio,dipartimento);
        this.stipendioMensile = stipendioMensile;
    }
}
