package Esercizio2;

public class Dirigente extends Dipendente {

    private double stipendioMensile;
    public Dirigente(String matricola, int stipendio, String dipartimento, double stipendioMensile  ){
        super(matricola,stipendio,dipartimento);
        this.stipendioMensile = stipendioMensile;
    }

}
