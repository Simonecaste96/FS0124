package epicode.entity;

import javax.persistence.*;
import java.time.LocalDate;

@Entity //SOLO CON QUESTA ANNOTAZIONE, FACCIO DIENTRE QUESTA CLASSE UNA TABELLA @Entity
@Table(name = "studenti") //NON è OBBLIGATORIO SERVE PER DARE INFO AGGIUNTIVE SULLA TABELA CHE ANDRA A MAPPARE QUESTA CLASSE @Table UTILE PER MANTENERE LE CONVENZIONI DI SCRITTURA UGUALI TRA JAVA E DATABASE
public class Studente {

    @Id // @ID FA CAPIRE ALLA DATABSE CHE QUESTA è LA CHIAVE PRIMARIA
    @GeneratedValue// @GENERATEDVALUE CREA IN AUTOMATICO LA MATRICOLA, è POSSIAMO AVERE Pù STRATEGIE DI CREAZIONE METTENDO (strategy)
    private int matricola;
    @Column (nullable = false,length = 30) //@COLUMN PERMETTE VARIE MODIFICHE RIGUARDO IL DATO IN QUESTIONE, NOME NOT NULL, LUNGHEZZA ecc,
    private String nome;
    @Column (nullable = false,length = 30)
    private String cognome;

    private String indirizzo;
    @Column (name = "data_nascita")
    private LocalDate dataNascita;



    public Studente(){} //  BUONA PRASSI AGGIUNGERE UN COSTRUTTORE VUOTO PERCHè VERRA UTILIZZATO DAL HIBERNATE, SE NON CI FOSSE
    // AVREBBE DATO ERRORE!

    public Studente(int matricola, String nome, String cognome, LocalDate dataNascita, String indirizzo) {
        this.matricola = matricola;
        this.nome = nome;
        this.cognome = cognome;
        this.dataNascita = dataNascita;
        this.indirizzo = indirizzo;
    }

    public int getMatricola() {
        return matricola;
    }

    public void setMatricola(int matricola) {
        this.matricola = matricola;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public String getIndirizzo() {
        return indirizzo;
    }

    public void setIndirizzo(String indirizzo) {
        this.indirizzo = indirizzo;
    }

    public LocalDate getDataNascita() {
        return dataNascita;
    }

    public void setDataNascita(LocalDate dataNascita) {
        this.dataNascita = dataNascita;
    }

    @Override
    public String toString() {
        return "Studente{" +
                "matricola=" + matricola +
                ", nome='" + nome + '\'' +
                ", cognome='" + cognome + '\'' +
                ", indirizzo='" + indirizzo + '\'' +
                ", dataNascita=" + dataNascita +
                '}';
    }
}
