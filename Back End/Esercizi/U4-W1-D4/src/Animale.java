
//OVERLOADING
public class Animale {

    private String nome;
    private int eta;
//IL COSTRUTTORE QUI SOTTO COMPRENDE TUTTE LE VARIABILI DI CLASSE
    public Animale(String nome, String colorePelo, int eta) {
        this.nome = nome;
        this.eta = eta;
    }

    //E POSSIBILE AVRE PIù DI UN COSTRUTTORE CON LO STESSO NOME MA CON PARAMETRI DIFFERENTI PER TIPO/PER NUMERO/PER ORDINE
    public Animale(){

    }

    public Animale(String nome){
        this.nome=nome;
    }




}
