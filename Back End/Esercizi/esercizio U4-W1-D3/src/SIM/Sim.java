package SIM;

public class Sim {
private String numero;
private double credito;
private String chiamate;


 public Sim(String numero,double credito, String chiamate){
  this.numero=numero;
  this.credito=credito;
  this.chiamate=chiamate;
 }

 public void ricarica(int ammontare){
 credito+=ammontare;
 }


    public String getNumero() {
        return numero;
    }

    public String getChiamate() {
        return chiamate;
    }

    public double getCredito() {
        return credito;
    }

    /*public void setNumero(String numero) {
        this.numero = numero;
    }

    public void setCredito(double credito) {
        this.credito = credito;
    }

    public void setChiamate(String chiamate) {
        this.chiamate = chiamate;
    }*/

    public void infoSim(){
        System.out.println("Numero SIM: " + getNumero());
        System.out.println("Credito: " + getCredito());
        System.out.println("Chiamate: " + getChiamate());
    }

}
