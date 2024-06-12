package it.epicode.u5w1d4esercizio.appConfig;


import it.epicode.u5w1d4esercizio.bean.*;
import it.epicode.u5w1d4esercizio.enums.StatoOrdine;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.Scope;


import java.util.List;

@Configuration
@PropertySource("application.properties")
public class AppConfig {

   @Bean
    public Menu getMenu (){
       Menu menu = new Menu();
       menu.setAntipasti(getAntipasti());
       menu.setPizze(getPizze());
       menu.setTopping(getToppings());
       menu.setBevande(getDrinks());
     return menu;
   };



    @Bean(name = "tavolo2")
    public Tavolo getTavolo2(){
        Tavolo tavolo2 = new Tavolo();
        tavolo2.setNumeroTavolo(2);
        tavolo2.setNumeroCopertiMax(3);
        tavolo2.setOccupato(true);
        return tavolo2;
    }

    @Bean(name = "tavolo4")
    public  Tavolo getTavolo4(){
        Tavolo tavolo4 = new Tavolo();
        tavolo4.setNumeroTavolo(4);
        tavolo4.setNumeroCopertiMax(3);
        tavolo4.setOccupato(true);
        return tavolo4;
    }



    @Bean(name="comandatavolo2")
    public Comanda getComanda1(){
        Comanda comandaTavolo2 = new Comanda();
        comandaTavolo2.setTavolo(getTavolo2());
        comandaTavolo2.setPax(3);
        comandaTavolo2.setAntipastiOrdinati(List.of(getAntipasti().get(1),getAntipasti().get(2),getAntipasti().get(3)));
        comandaTavolo2.setPizzeOrdinate(List.of(getPizze().get(3),getPizze().get(0),getPizze().get(5)));
        comandaTavolo2.setDrinkOrdinati(List.of(getDrinks().get(1),getDrinks().get(2),getDrinks().get(3)));
        comandaTavolo2.setStatoOrdine(StatoOrdine.IN_CORSO);
        return comandaTavolo2;
    }

    @Bean(name = "comandatavolo4")
    public Comanda getComanda2(){
        Comanda comandaTavolo4 = new Comanda();
        comandaTavolo4.setTavolo(getTavolo4());
        comandaTavolo4.setPax(3);
        comandaTavolo4.setAntipastiOrdinati(List.of(getAntipasti().get(1),getAntipasti().get(4),getAntipasti().get(0)));
        comandaTavolo4.setPizzeOrdinate(List.of(getPizze().get(0),getPizze().get(1),getPizze().get(4)));
        comandaTavolo4.setDrinkOrdinati(List.of(getDrinks().get(0),getDrinks().get(1),getDrinks().get(2)));
        comandaTavolo4.setStatoOrdine(StatoOrdine.SERVITO);
        return comandaTavolo4;
    }





   @Bean(name="toppings")
   @Scope("prototype")
   public List<Topping> getToppings(){
       Topping pomodoro = new Topping();
       pomodoro.setNome("Pomodoro");
       pomodoro.setCalorie(30);

       Topping mozzarella = new Topping();
       mozzarella.setNome("Mozzarella");
       mozzarella.setCalorie(70);

       Topping basilico = new Topping();
       basilico.setNome("Basilico");
       basilico.setCalorie(0);

       Topping alici = new Topping();
       alici.setNome("Alici");
       alici.setCalorie(50);

       Topping mozzarellabufala = new Topping();
       mozzarellabufala.setNome("Mozzarella di Bufala");
       mozzarellabufala.setCalorie(85);

       Topping fioridizucca = new Topping();
       fioridizucca.setNome("Fiori di Zucca");
       fioridizucca.setCalorie(25);

       Topping funghi = new Topping();
       funghi.setNome("Funghi");
       funghi.setCalorie(20);

       Topping salsiccia = new Topping();
       salsiccia.setNome("Salsiccia");
       salsiccia.setCalorie(95);

       Topping carciofini = new Topping();
       carciofini.setNome("Carciofini");
       carciofini.setCalorie(40);

       Topping prosciuttocrudo = new Topping();
       prosciuttocrudo.setNome("Prosciutto crudo");
       prosciuttocrudo.setCalorie(50);

       Topping prosciuttocotto = new Topping();
       prosciuttocotto.setNome("Prosciutto cotto");
       prosciuttocotto.setCalorie(50);

       Topping gamebretti = new Topping();
       gamebretti.setNome("Gamberetti");
       gamebretti.setCalorie(20);

       Topping rucola = new Topping();
       rucola.setNome("Rughetta");
       rucola.setCalorie(0);

       Topping pomodorini = new Topping();
       pomodorini.setNome("Pomodorini");
       pomodorini.setCalorie(0);

       return List.of(pomodoro, mozzarella, alici, mozzarellabufala, fioridizucca, funghi, salsiccia, carciofini, prosciuttocrudo, prosciuttocotto,gamebretti,rucola,pomodorini);

   }


    @Bean(name="pizze")
    @Scope("prototype")
    public List<Pizze> getPizze (){

        Pizze margherita = new Pizze();

        margherita.setNome("Margherita con bufala");
        margherita.setIngredienti(List.of(getToppings().get(0),getToppings().get(2),getToppings().get(4)));
        margherita.setCalorieBase(30);
        margherita.setXl(false);
        margherita.setExtra(List.of());
        margherita.setPrezzoBase(8.50);


        Pizze fiorialici = new Pizze();


        fiorialici.setNome("Fiori e alici");
        fiorialici.setIngredienti(List.of(getToppings().get(3),getToppings().get(5),getToppings().get(1)));
        fiorialici.setCalorieBase(30);
        fiorialici.setXl(false);
        fiorialici.setExtra(List.of());
        fiorialici.setPrezzoBase(8.50);


        Pizze capricciosa = new Pizze();


        capricciosa.setNome("Capricciosa");
        capricciosa.setIngredienti(List.of(getToppings().get(0),getToppings().get(8),getToppings().get(9)));
        capricciosa.setCalorieBase(30);
        capricciosa.setXl(false);
        capricciosa.setExtra(null);
        capricciosa.setPrezzoBase(8.50);


        Pizze napoli = new Pizze();
        napoli.setNome("Napoli");
        napoli.setIngredienti(List.of(getToppings().get(0),getToppings().get(3),getToppings().get(4)));
        napoli.setCalorieBase(30);
        napoli.setXl(false);
        napoli.setExtra(null);
        napoli.setPrezzoBase(8.50);


        Pizze gamberi = new Pizze();
        gamberi.setNome("Gamberizzed");
        gamberi.setIngredienti(List.of(getToppings().get(0),getToppings().get(11),getToppings().get(12)));
        gamberi.setCalorieBase(30);
        gamberi.setXl(false);
        gamberi.setExtra(null);
        gamberi.setPrezzoBase(8.50);


        Pizze specialone = new Pizze();
        specialone.setNome("Special One");
        specialone.setIngredienti(List.of(getToppings().getLast(),getToppings().get(9),getToppings().get(12)));
        specialone.setCalorieBase(30);
        specialone.setXl(false);
        specialone.setExtra(null);
        specialone.setPrezzoBase(10);


        Pizze crostino = new Pizze();
        crostino.setNome("Crostinohh!");
        crostino.setIngredienti(List.of(getToppings().get(1),getToppings().get(11)));
        crostino.setCalorieBase(30);
        crostino.setXl(false);
        crostino.setExtra(null);
        crostino.setPrezzoBase(8.50);




        return  List.of(margherita,fiorialici,capricciosa,napoli,gamberi,specialone,crostino);
    };



    @Bean(name = "drinks")
    @Scope("prototype")
    public List<Drink> getDrinks(){
        Drink acquaNat = new Drink();
        acquaNat.setNome("Acqua naturale");
        acquaNat.setCalorie(25);
        acquaNat.setPrezzo(2);
        acquaNat.setGradazioneAlcolica(0);
        acquaNat.setCl(100);



        Drink acquaFriz = new Drink();
        acquaFriz.setNome("Acqua naturale");
        acquaFriz.setCalorie(25);
        acquaFriz.setPrezzo(2);
        acquaFriz.setGradazioneAlcolica(0);
        acquaFriz.setCl(100);


        Drink cocacola = new Drink();
        cocacola.setNome("Acqua naturale");
        cocacola.setCalorie(50);
        cocacola.setPrezzo(3.5);
        cocacola.setGradazioneAlcolica(0);
        cocacola.setCl(33);

        Drink birraPeroni = new Drink();
        birraPeroni.setNome("Birra Peroni");
        birraPeroni.setCalorie(50);
        birraPeroni.setPrezzo(5);
        birraPeroni.setGradazioneAlcolica(5);
        birraPeroni.setCl(66);


        Drink caffe = new Drink();
        caffe.setNome("Acqua naturale");
        caffe.setCalorie(5);
        caffe.setPrezzo(1);
        caffe.setGradazioneAlcolica(0);
        caffe.setCl(0);


        return  List.of(acquaFriz,acquaNat,cocacola,birraPeroni,caffe);

    }


    @Bean(name = "antipasti")
    @Scope("prototype")
    public List<Antipasti> getAntipasti(){

        Antipasti suppliclassico = new Antipasti();
        suppliclassico.setNome("Supplì classico");
        suppliclassico.setCalorie(90);
        suppliclassico.setPrezzo(1.50);

        Antipasti supplicarbonara = new Antipasti();
        supplicarbonara.setNome("Supplì carbonara");
        supplicarbonara.setCalorie(90);
        supplicarbonara.setPrezzo(2);

        Antipasti suppliamatriciana = new Antipasti();
        suppliamatriciana.setNome("Supplì amatriciana");
        suppliamatriciana.setCalorie(90);
        suppliamatriciana.setPrezzo(2);

        Antipasti fioredizucca = new Antipasti();
        fioredizucca.setNome("Fiore di zucca");
        fioredizucca.setCalorie(150);
        fioredizucca.setPrezzo(2.50);

        Antipasti frittomisto = new Antipasti();
        frittomisto.setNome("Fritto misto della casa");
        frittomisto.setCalorie(250);
        frittomisto.setPrezzo(9);

        Antipasti trisbruschette = new Antipasti();
        trisbruschette.setNome("Tris di bruschette");
        trisbruschette.setCalorie(100);
        trisbruschette.setPrezzo(5);

        return List.of(suppliclassico,suppliamatriciana,supplicarbonara,fioredizucca,frittomisto,trisbruschette);
    }




}
