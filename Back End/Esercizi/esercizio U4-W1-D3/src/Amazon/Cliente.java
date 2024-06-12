package Amazon;

import java.util.Date;

public class Cliente {

    private String codice;
    private String nome;
    private String cognome;
    private String email;
    private String dataIscrizione;


    public Cliente(String nome,String cognome,String email,String dataIscrizione,String codice){
        this.nome=nome;
        this.cognome=cognome;
        this.email=email;
        this.dataIscrizione=dataIscrizione;
        this.codice=codice;
    }


    public String getCodice() {
        return codice;
    }

    public void setCodice(String codice) {
        this.codice = codice;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDataIscrizione() {
        return dataIscrizione;
    }

    public void setDataIscrizione(String dataIscrizione) {
        this.dataIscrizione = dataIscrizione;
    }
}
