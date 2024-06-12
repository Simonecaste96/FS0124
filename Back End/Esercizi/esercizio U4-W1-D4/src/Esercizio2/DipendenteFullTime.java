package Esercizio2;

public class DipendenteFullTime extends Dipendente {

    private double stipendioMensile;
    public DipendenteFullTime(String matricola, int stipendio, String dipartimento, double stipendioMensile ){
        super(matricola,stipendio,dipartimento);
        this.stipendioMensile = stipendioMensile;
    }

   // @Override
    public double calculateSalary(){
        return stipendioMensile;
    }
}
