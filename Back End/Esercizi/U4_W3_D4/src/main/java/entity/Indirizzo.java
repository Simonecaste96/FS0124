package entity;

import javax.persistence.*;
//Reazione di tipo 1 a 1, dobbiamo creare una nuova classe,
// in questo caso inrizzo ed annotarla con Embeddable, e nell'alltra classe crare un instanza di questa
// classe nelle sue varibili, annotarla con Embedded, fare GET/SET in wuesyo modo tutti i dati della classe indirizzo
// convergeranno nella classe studenti, cosi da avere sul DB UNA SOLA TABBELLA.
//@Embeddable


//Relazione 1 to 1, faccio diventare indirizzo una tabella a parte creando una relazione 1 to 1 con studente,
//percioò uso ANNOTAZIONI ENTITY E TABLE,  ED AGGIUNGOO  LA VARIABILE ID USANDO LE ANNOTAZIONI ID E GENERATED VALUE
@Entity
@Table(name="indirizzi")
public class Indirizzo {
    @Id
    @GeneratedValue
    private int id;

    private String via;
    private String comune;
    private String provincia;

    public Indirizzo(/*Aggiunto id per esempio 1 TO 1*/int id,String via, String comune, String provincia) {
        /*Aggiunto id per esempio 1 TO 1*/   this.id= id;
        this.via = via;
        this.comune = comune;
        this.provincia = provincia;
    }


    /*Aggiunto id per esempio 1 TO 1*/
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Indirizzo() {
    }

    public String getVia() {
        return via;
    }

    public void setVia(String via) {
        this.via = via;
    }

    public String getComune() {
        return comune;
    }

    public void setComune(String comune) {
        this.comune = comune;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    @Override
    public String toString() {
        return "Indirizzo{" +
                "via='" + via + '\'' +
                ", comune='" + comune + '\'' +
                ", provincia='" + provincia + '\'' +
                '}';
    }
}
