package Banca;

public class ContoBancario {
    private String numeroConto;
    private  int bilancio;


    public ContoBancario(String numeroConto){
        this.numeroConto=numeroConto;
        //non sccrivo che bilancio parte da 0 poichè java iposta gia da zero int
    }

    public ContoBancario(String numeroConto, int bilancio){
        this.numeroConto=numeroConto;
        this.bilancio=bilancio;
    }

//short cut premi alt+ins e selezioni get oppure set in base a cio che ti serve
    public int getBilancio() {
        //System.out.println("Il numero del suo conto bancario è: "+this.bilancio+" €");
        return bilancio;
    }

    public String getNumeroConto() {
        return numeroConto;
    }

    //metodo voi va a modificare/incrementare lo stato di un oggetto, perciò e void non int!
    public void deposito(int ammontare){
    bilancio = bilancio + ammontare;
    }

    public boolean prelievo(int ammontare){
      if(ammontare<=bilancio){
          bilancio= bilancio-ammontare;
          return true;
      }
      else{
          System.out.println("Ma fai il serio non hai una lira!");


          return false;
      }


    }

}
