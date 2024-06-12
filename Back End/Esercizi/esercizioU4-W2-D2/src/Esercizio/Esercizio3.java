package Esercizio;

public class Esercizio3 {

    public static void main(String[] args) {
        Rubrica rubrica = new Rubrica();


        rubrica.inserisciCoppia("Matteo","3405692668");
        rubrica.inserisciCoppia("Paolo","3405692443");
        rubrica.inserisciCoppia("Simone","3246059465");

        System.out.println(rubrica.contatti);
        rubrica.ricercaPerNome("Simone");
        rubrica.cancellaCoppia("3405692443");
    }
}
