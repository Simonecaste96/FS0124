package ElementoMultimediale;

/*public class Immagine extends  ElementoMultimediale implements Riproduci{
    private int luminosita;

    public Immagine(String title, String durata, int luminosita) {
        super(title, durata);
        this.luminosita = luminosita;
    }

    @Override
    public int getLuminosita() {
        return luminosita;
    }


    @Override
    public void setLuminosita(int luminosita) {
        Riproduci.super.setLuminosita(luminosita);
    }
}*/
public class Immagine extends  ElementoMultimediale {
    private int luminosita;

    public Immagine(String title, int durata, int luminosita) {
        super(title, durata);
        this.luminosita = luminosita;
    }

    public int getLuminosita() {
        return luminosita;
    }

    public void setLuminosita(int luminosita) {
        this.luminosita = luminosita;
    }
    public void alzaLuminosita() {
        this.luminosita++;
    }
    public void abbassaLuminosita() {
        this.luminosita--;
    }

    public void show() {
        //se riprodotto appare titolo + punti esclamativi pari alla durata
        StringBuilder linea = new StringBuilder(getTitle());
        for (int i = 0; i < getLuminosita(); i++) {
            linea.append("*");
        }
        System.out.println(linea.toString());
    }
}
