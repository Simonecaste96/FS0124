package SIM;

public class ClienteSim {
    public static void main(String[] args) {
        Sim sim1 = new Sim("3246059465",0,"3405692668, durata: 02.13");


        sim1.infoSim();
        sim1.ricarica(20);
        sim1.infoSim();
    }

}
