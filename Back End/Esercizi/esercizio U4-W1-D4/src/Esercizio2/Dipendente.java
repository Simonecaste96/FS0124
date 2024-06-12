package Esercizio2;

public abstract class Dipendente {
    private String matricola;
    private int stipendio;
    public String dipartimento;

    public Dipendente(String matricola, int stipendio, String dipartimento) {
        this.stipendio = stipendio;
        this.matricola = matricola;
        this.dipartimento = dipartimento;
    }

    public String getMatricola() {
        return matricola;
    }


    public int getStipendio() {
        return stipendio;
    }


    public String getDipartimento() {
        return dipartimento;
    }

    public void setDipartimento(String dipartimento) {
        this.dipartimento = dipartimento;
    }
}
