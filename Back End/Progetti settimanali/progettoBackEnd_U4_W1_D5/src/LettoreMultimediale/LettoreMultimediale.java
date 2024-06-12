/*package LettoreMultimediale;
import ElementoMultimediale.*;


import java.util.Scanner;

public class LettoreMultimediale extends ElementoMultimediale implements Riproduci {


    public LettoreMultimediale(String title, String formato) {
        super(title, formato);
    }

    public static void main(String[] args) {

    }


    static Scanner scanner = new Scanner(System.in);



    private static LettoreMultimediale[] playlist = new LettoreMultimediale[5];
    @Override
    public void setLuminosita(int luminosita) {
        Riproduci.super.setLuminosita(luminosita);
    }
    public static void esegui() {
        // Inserimento degli elementi multimediali dall'utente
        for (int i = 0; i < playlist.length; i++) {
            System.out.println("Inserisci l'elemento multimediale #" + (i + 1));
            System.out.print("Titolo: ");
            String titolo = scanner.nextLine();
            System.out.print("Formato: ");
            String formato = scanner.nextLine();
            System.out.print("Tipo (1 per Immagine, 2 per Video, 3 per Registrazione Audio): ");
            int tipo = scanner.nextInt();
            scanner.nextLine(); // Consuma il carattere di nuova riga residuo

            switch (tipo) {
                case 1:
                    // Creazione di un oggetto Immagine
                    int luminositaImmagine = 0;
                   playlist[i] = Immagine immagine = new Immagine(titolo, formato, luminositaImmagine);
                    break;
                case 2:
                    // Creazione di un oggetto Video
                    System.out.print("Durata: ");
                    double durataVideo = scanner.nextDouble();

                    int volumeVideo = 0;
                    int luminositaVideo = 0;
                     // Consuma il carattere di nuova riga residuo
                   Video video = new Video (titolo, formato, durataVideo, volumeVideo, luminositaVideo);
                    break;
                case 3:
                    // Creazione di un oggetto RegistrazioneAudio
                    System.out.print("Durata: ");
                    double durataAudio = scanner.nextDouble();
                    int volumeAudio = 0;
                    RegistrazioneAudio registrazioneAudio = new RegistrazioneAudio(titolo, formato, durataAudio,volumeAudio);
                    break;
                default:
                    System.out.println("Tipo non valido. Elemento multimediale non inserito.");
            }
        }

        // Riproduzione degli elementi multimediali finché l'utente non decide di terminare
        int scelta;
        do {
            System.out.println("\nScegli quale elemento multimediale riprodurre (1-5), oppure 0 per terminare:");
            scelta = scanner.nextInt();
            scanner.nextLine(); // Consuma il carattere di nuova riga residuo
            if (scelta >= 1 && scelta <= 5) {
                playlist[scelta - 1].play();
            } else if (scelta != 0) {
                System.out.println("Scelta non valida.");
            }
        } while (scelta != 0);

        // Chiude lo scanner alla fine
        scanner.close();
    }
}*/
package LettoreMultimediale;

import ElementoMultimediale.*;

import java.util.Scanner;

/*public class LettoreMultimediale extends ElementoMultimediale implements Riproduci {


    public static int luminosita;

    public static int volume;


    public static double durata;


    public LettoreMultimediale(String title, String formato, int luminosita, double durata, int volume) {
        super(title, formato);

        this.luminosita = luminosita;
        this.volume = volume;
        this.durata = durata;

    }

    public static void main(String[] args) {
        esegui();
    }


    public static LettoreMultimediale[] playlist = new LettoreMultimediale[5];

    public static void esegui() {
        Scanner scanner = new Scanner(System.in);

        for (int i = 0; i < playlist.length; i++) {
            System.out.println("Inserisci l'elemento multimediale N°" + (i + 1));
            System.out.println("Tipo di file multimediale da creare (1 per Immagine, 2 per Video, 3 per Registrazione Audio): ");
            int scelta = scanner.nextInt();
            scanner.nextLine(); // Consuma il newline rimanente dopo nextInt()
            System.out.println("Titolo: ");
            String titolo = scanner.nextLine();
            System.out.println("Formato: ");
            String formato = scanner.nextLine();

            switch (scelta) {
                case 1:
                    // Creazione di un oggetto Immagine
                    System.out.print("Luminosita: ");
                    luminosita = scanner.nextInt();
                    scanner.nextLine(); // Consuma il newline rimanente dopo nextInt()
                    playlist[i] = new LettoreMultimediale(titolo, formato, luminosita, 0, 0);
                    break;
                case 2:
                    // Creazione di un oggetto Video
                    System.out.print("Durata: ");
                    durata = scanner.nextDouble();
                    scanner.nextLine(); // Consuma il newline rimanente dopo nextDouble()
                    System.out.print("Volume: ");
                    volume = scanner.nextInt();
                    scanner.nextLine(); // Consuma il newline rimanente dopo nextInt()
                    System.out.print("Luminosità: ");
                    luminosita = scanner.nextInt();
                    scanner.nextLine(); // Consuma il newline rimanente dopo nextInt()
                    playlist[i] = new LettoreMultimediale(titolo, formato, luminosita, durata, volume);
                    break;
                case 3:
                    // Creazione di un oggetto RegistrazioneAudio
                    System.out.print("Durata: ");
                    durata = scanner.nextDouble();
                    scanner.nextLine(); // Consuma il newline rimanente dopo nextDouble()
                    System.out.print("Volume: ");
                    volume = scanner.nextInt();
                    scanner.nextLine(); // Consuma il newline rimanente dopo nextInt()
                    playlist[i] = new LettoreMultimediale(titolo, formato, 0, durata, volume);
                    break;
                default:
                    System.out.println("Tipo non valido. Elemento multimediale non inserito.");
            }

        }
        for (int j = 0; j < playlist.length; j++) {
            LettoreMultimediale media = playlist[j];
            System.out.println("File N° " + j + " - " + media.getTitleAndFormat());
        }*/

        //non sono riuscito a creare il menu
        /*
        // Dichiarazione della variabile di scelta
        int scelta = -1;

// Menu per la riproduzione degli elementi multimediali
        for (int f = 0; f < playlist.length; f++) {
           String list = playlist[f].getTitleAndFormat();
            System.out.println("I tuoi file: " + list);

        }
        for (; scelta != 0; ) {
            System.out.println("Scegli quale elemento multimediale riprodurre (1-5), oppure 0 per terminare:");
            scelta = scanner.nextInt();
            scanner.nextLine(); // Consuma il carattere di nuova riga residuo

            if (scelta >= 1 && scelta <= 5) {
                LettoreMultimediale media = playlist[scelta - 1];
                media.getTitleAndFormat();

                // Riproduzione dell'elemento multimediale
                double durata = LettoreMultimediale.durata;
                int volume = LettoreMultimediale.volume;
                int luminosita = LettoreMultimediale.luminosita;


                for (int j = 0; j < playlist.length; j++) {
                    // Stampa del titolo con
                    System.out.println("File N° " +j+ media.getTitleAndFormat());

                    // Stampa della sequenza di punti esclamativi (lunghezza pari al volume)
                    for (int k = 0; k < volume; k++) {
                        System.out.print("!");
                    }
                    System.out.println();

                    // Stampa della sequenza di asterischi (lunghezza pari alla luminosità)
                    for (int k = 0; k < luminosita; k++) {
                        System.out.print("*");
                    }
                    System.out.println();
                }
            } else if (scelta != 0) {
                System.out.println("Scelta non valida.");
            }
        }

// Chiusura dello scanner alla fine
        scanner.close();

    }
    }
}*/

public class LettoreMultimediale extends ElementoMultimediale {

    public LettoreMultimediale(String title, double durata) {
        super(title, durata);
    }

    public static void main(String[] args) {
        esegui();
       riproduciScelta();
    }


    public static ElementoMultimediale[] playlist = new ElementoMultimediale[5];

    public static void esegui() {
        Scanner scanner = new Scanner(System.in);

        for (int i = 0; i < playlist.length; i++) {
            System.out.println("Inserisci l'elemento multimediale N°" + (i + 1));
            System.out.println("Tipo di file multimediale da creare (1 per Immagine, 2 per Video, 3 per Registrazione Audio): ");
            int scelta = scanner.nextInt();
            scanner.nextLine(); // Consuma il carattere di nuova riga rimanente

            switch (scelta) {
                case 1:
                    System.out.println("Titolo: ");
                    String titoloImg = scanner.nextLine();
                    System.out.println("Luminosità: ");
                    int luminosita = scanner.nextInt();
                    Immagine immagine = new Immagine(titoloImg, 0,luminosita);
                    playlist[i] = immagine;
                    break;
                case 2:
                    System.out.println("Titolo: ");
                    String titoloVideo = scanner.nextLine();
                    System.out.println("Durata: ");
                    double durataVideo = scanner.nextDouble();
                    System.out.println("Volume: ");
                    int volumeVideo = scanner.nextInt();
                    System.out.println("Luminosità: ");
                    int luminositaVideo = scanner.nextInt();
                    Video video = new Video(titoloVideo, durataVideo,volumeVideo, luminositaVideo);
                    playlist[i]= video;
                    break;
                case 3:
                    System.out.println("Titolo: ");
                    String titoloAudio = scanner.nextLine();
                    System.out.println("Durata: ");
                    double durataAudio = scanner.nextDouble();
                    System.out.println("Volume: ");
                    int volumeAudio = scanner.nextInt();

                    RegistrazioneAudio registrazioneAudio = new RegistrazioneAudio(titoloAudio, durataAudio,volumeAudio);
                    playlist[i]= registrazioneAudio;
                    break;
                default:
                    System.out.println("Tipo non valido. Elemento multimediale non inserito.");
            }

        }
        for (int j = 0; j < playlist.length; j++) {
            ElementoMultimediale media = playlist[j];
            if (media != null) {
                System.out.println("File N° " + (j+1) + " - " + media.getTitle());
            }
        }
    }





    public static void riproduciScelta() {
        Scanner scanner = new Scanner(System.in);

        int numeroElemento;
        do {
            System.out.println("Quale elemento vuoi riprodurre? (1-5, premi 0 per uscire)");
            numeroElemento = scanner.nextInt();
            scanner.nextLine(); // Consuma il carattere di nuova riga rimanente

            if (numeroElemento == 0) {
                break; // Uscita dal ciclo se l'utente ha premuto 0
            }

            if (numeroElemento < 1 || numeroElemento > 5) {
                System.out.println("Numero elemento non valido.");
                continue; // Ripeti il ciclo se il numero non è valido
            }

            ElementoMultimediale media = playlist[numeroElemento - 1];
            if (media != null) {
                System.out.println("Riproduzione di: " + media.getTitle());
                if (media instanceof Video) {
                    ((Video) media).playVideo();
                } else if (media instanceof RegistrazioneAudio) {
                    ((RegistrazioneAudio) media).play();
                } else if (media instanceof Immagine) {
                    ((Immagine) media).show();
                } else {
                    System.out.println("Tipo di file non supportato per la riproduzione.");
                }
            } else {
                System.out.println("Nessun elemento multimediale presente con il numero specificato.");
            }
        } while (numeroElemento != 0);

        // Chiusura dello scanner alla fine
        scanner.close();
    }

}


