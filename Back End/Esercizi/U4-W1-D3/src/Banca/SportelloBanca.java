package Banca;

public class SportelloBanca {
    public static void main(String[] args) {
        ContoBancario contobancario = new ContoBancario("IT081929473LOG0129005");
        System.out.println("Il numero del suo conto bancario è: "+contobancario.getNumeroConto());
        System.out.println("Il numero del suo conto bancario è: "+contobancario.getBilancio()+" €");

        contobancario.deposito(300);

        System.out.println("Il numero del suo conto bancario è: "+contobancario.getBilancio()+" €");

        contobancario.prelievo(350);

        System.out.println("Il numero del suo conto bancario è: "+contobancario.getBilancio()+" €");

    }

}
