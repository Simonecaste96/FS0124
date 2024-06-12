package ElementoMultimediale;

/*public class Video extends  ElementoMultimediale  {
    private double durata;
    private int volume;
    private int luminosita;

    public Video(String title, String formato, double durata, int volume, int luminosita) {
        super(title, formato);
        this.durata = durata;
        this.volume = volume;
        this.luminosita = luminosita;
    }

    public double getDurata() {
        return durata;
    }

    public void setDurata(double durata) {
        this.durata = durata;
    }
    public int getVolume() {
        return volume;
    }

    public void alzaVolume(int volume) {
        this.volume = volume += 1;
    }
    public void abbassaVolume(int volume) {
        this.volume = volume += 1;
    }

    public int getLuminosita() {
        return luminosita;
    }
    @Override
    public void setLuminosita(int luminosita) {
        Riproduci.super.setLuminosita(luminosita);
    }
    public void playVideo() {
        //se riprodotto appare titolo + punti esclamativi pari al volume + asterischi pari alla luminosità
        StringBuilder linea = new StringBuilder(getTitleAndFormat());
        for (int i = 0; i < getVolume(); i++) {
            linea.append("*");
        }
        for (int j = 0; j < getLuminosita(); j++) {
            linea.append("!");
        }
        System.out.println(linea.toString());
    }
}*/
public class Video extends  ElementoMultimediale  {
    private int volume;
    private int luminosita;

    public Video(String title, double durata, int volume, int luminosita) {
        super(title, durata);
        this.volume = volume;
        this.luminosita = luminosita;
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    public void abbassaVolume() {
        this.volume--;
    }
    public void alzaVolume() {
        this.volume++;
    }

    public int getLuminosita() {
        return luminosita;
    }

    public void setLuminosita(int luminosita) {
        this.luminosita = luminosita;
    }
    public void abbassaLuminosita() {
        this.luminosita--;
    }
    public void alzaLuminosita() {
        this.luminosita++;
    }

    public void playVideo() {
        //se riprodotto appare titolo + punti esclamativi pari al volume + asterischi pari alla luminosità
        StringBuilder linea = new StringBuilder(getTitle());
        for (int i = 0; i < getVolume(); i++) {
            linea.append("*");
        }
        for (int j = 0; j < getLuminosita(); j++) {
            linea.append("!");
        }
        System.out.println(linea.toString());
    }
}