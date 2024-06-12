package Amazon;

public class Home {
    public static void main(String[] args) {
        Cliente cliente = new Cliente("Simone","Castelluccio","simonecaste96@gmail.com","16-07-2021","10");

Articolo a1 = new Articolo(5.2,"Set colori","12", 3);

    Articolo[] articoli = new Articolo[3];
articoli[0]=a1;
Carrello carrello = new Carrello(cliente);
carrello.setArticoli(articoli);

        System.out.println(carrello);


    }


}
