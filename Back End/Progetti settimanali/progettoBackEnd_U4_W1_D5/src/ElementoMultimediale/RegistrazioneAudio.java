package ElementoMultimediale;

/*public class RegistrazioneAudio extends  ElementoMultimediale implements Riproduci{
    private double durata;
    private int volume;

    public RegistrazioneAudio(String title, String formato,double durata,int volume) {
        super(title, formato);
        this.durata = durata;
        this.volume = volume;
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

    public void setVolume(int volume) {
        this.volume = volume;
    }

    public void playAudio() {
        //se riprodotto appare titolo + punti esclamativi pari alla durata
        StringBuilder linea = new StringBuilder(getTitleAndFormat());
        for (int j = 0; j < getVolume(); j++) {
            linea.append("!");
        }
        System.out.println(linea.toString());
    }

}*/

public class RegistrazioneAudio extends  ElementoMultimediale  {
    private int volume;

    public RegistrazioneAudio(String title, double durata, int volume) {
        super(title, durata);
        this.volume = volume;
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


    public void play() {
        for (int i = 0; i < getDurata(); i++) {
            System.out.print(getTitle());
            for (int j = 0; j < getVolume(); j++) {
                System.out.print("!");
            }
            System.out.println();
        }
    }
}

