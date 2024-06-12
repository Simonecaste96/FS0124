//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

      Dipendente dipendente1 = new Dipendente("300301",1500,"Produzione");
        Dipendente dipendente2 = new Dipendente("400605",1600,"Amministrazione");
        Dipendente dipendente3 = new Dipendente("360354",1300,"Vendite");

    Dipendente [] dipendenti = {dipendente1,dipendente2,dipendente3};



    /*questo è un ciclo for classico
        for(int i=0; i<dipendenti.length; i++){
        Dipendente dipendente = dipendenti[i];
            System.out.println("La Matricola è: " + dipendente.getMatricola());}*/

        // questo è un ciclo forEach
        for (Dipendente dipendente : dipendenti) {
            System.out.println("La Matricola é: " + dipendente.getMatricola());
        }
    }

}