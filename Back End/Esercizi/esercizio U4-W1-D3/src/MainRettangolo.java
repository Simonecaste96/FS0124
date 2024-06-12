public class MainRettangolo {
    public static void main(String[] args) {

        System.out.println("-------------------------");
        System.out.println("Primo rettangolo");
        Rettangolo rettangolo1 = new Rettangolo(20,15);
        rettangolo1.stampaRettangolo();

        System.out.println("-------------------------");
        System.out.println("Secondo rettangolo");
        Rettangolo rettangolo2 = new Rettangolo(26,13);
        rettangolo2.stampaRettangolo();

        System.out.println("-------------------------");
        System.out.println("Somma delle loro aree e perimetri:");
        rettangolo1.stampaDueRettangoli(rettangolo1,rettangolo2);



    }
}
