package Amazon;

public class Articolo {
    private String  codice;
    private String descrizione;
    private double prezzo;
    private int numeroPz;

    public Articolo(double prezzo, String descrizione, String codice, int numeroPz) {
        this.prezzo = prezzo;
        this.descrizione = descrizione;
        this.codice = codice;
        this.numeroPz = numeroPz;
    }

    public double getPrezzo() {
        return prezzo;
    }
}

