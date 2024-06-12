package it.epicodeEsercizio.Esercizio_U4_W4_D1.appConfig;

import it.epicodeEsercizio.Esercizio_U4_W4_D1.bean.*;
import it.epicodeEsercizio.Esercizio_U4_W4_D1.enums.StatoOrdine;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDateTime;
import java.util.List;

@Configuration
public class AppConfig {

   @Bean
    public Menu getMenu (){
     return new Menu(getDrinks(),getAntipasti(),getPizze(),getToppings());
   };



   @Bean
   public Tavolo  getTavolo2(){
       Tavolo tavolo2 = new Tavolo();
       tavolo2.setNumeroTavolo(2);
       tavolo2.setNumeroCopertiMax(3);
       tavolo2.setOccupato(true);
       tavolo2.setConto(getComanda1());
       return tavolo2;


   }
    @Bean
   public  Tavolo getTavolo4(){
        Tavolo tavolo4 = new Tavolo();
        tavolo4.setNumeroTavolo(4);
        tavolo4.setNumeroCopertiMax(3);
        tavolo4.setOccupato(true);
        tavolo4.setConto(getComanda2());
        return tavolo4;
    }



    @Bean
    public Comanda getComanda1(){
        return new Comanda(getTavolo2(),List.of(getPizze().get(1),getPizze().get(3),getPizze().get(6)),List.of(getAntipasti().get(3),getAntipasti().get(6)),List.of(getDrinks().get(0),getDrinks().get(3),getDrinks().get(4)),1, StatoOrdine.IN_CORSO,3);
    }
    @Bean
    public Comanda getComanda2(){
        return new Comanda(getTavolo4(),List.of(getPizze().get(2),getPizze().get(4),getPizze().get(0)),List.of(getAntipasti().get(5),getAntipasti().get(1)),List.of(getDrinks().get(3),getDrinks().get(1),getDrinks().get(2)),2, StatoOrdine.PRONTO,3);
    }



   @Bean
   public List<Topping> getToppings(){
       return List.of(new Topping("Basilico",0)
               ,new Topping("Pomodoro",10)
               ,new Topping("Mozzarella di bufala",30)
               ,new Topping("Mozzarella",30)
               ,new Topping("Alici",100)
               ,new Topping("Fiori di zucca",5)
               ,new Topping("Funghi",5)
               ,new Topping("Carciofini",3)
               ,new Topping("Prosciutto crudo",3)
               ,new Topping("Prosciutto cotto",10)
               ,new Topping("Uovo sodo",100)
               ,new Topping("Zucchine",100)
               ,new Topping("Melanzane",100)
               ,new Topping("Peperoni",100)
               ,new Topping("Pomodoro ciliegino",20)
               ,new Topping("Speck",100)
               ,new Topping("Salsiccia",100)
               ,new Topping("Patate",100)
               ,new Topping("Gorgonzola",100)
               ,new Topping("Radicchio",100)
       );
   }

    @Bean
    public List<Pizze> getPizze (){
        return List.of(new Pizze("Margherita con bufala", false, List.of(new Topping("Basilico",10),new Topping("Pomodoro",10),new Topping("Mozzarella di bufala",30)),8.50,30,null)
                ,new Pizze("Fiori e Alici", false, List.of(new Topping("Alici",10),new Topping("Fiori di zucca",20),new Topping("Mozzarella",30)),7,30,null)
                ,new Pizze ("Capricciosa", false, List.of(new Topping("Mozzarella",10),new Topping("Pomodoro",20),new Topping("Uovo sodo",30)),7,30,null)
               ,new Pizze ("Napoli", false,List.of(new Topping("Mozzarella",10),new Topping("Pomodoro",10),new Topping("Alici",10)),10,30,null)
                ,new Pizze ("Gamberi", false,List.of(new Topping("Pomodoro",0),new Topping("Rucola",0),new Topping("Salsa rosa",10)),13,30,null)
                ,new Pizze ("Special One", false,List.of(new Topping("Parmigiano",30),new Topping("Prosciutto crudo",3),new Topping("Pomodoro ciliegino",20),new Topping("Rucola",0)),12,30,null)
                ,new Pizze ("Crostino", false,List.of(new Topping("Prosciutto cotto",10),new Topping("Mozzarella",30)),14,30,null)


        );
    };



    @Bean
    public List<Drink> getDrinks(){
        return List.of(new Drink("Coca-zero",0,3.50)
        ,new Drink("Acqua frizzante",10,2)
                ,new Drink("Acqua naturale",10,2)
                ,new Drink("Coca-cola",100,3.50)
                ,new Drink("Peroni 66cl",5,5)
                ,new Drink("Peroni 33cl",5,3.50)
                ,new Drink("Chinotto",3,3)
                ,new Drink("Fanta",3,3.50)
                ,new Drink("Sprite",3,3)
                ,new Drink("Pepsi",100,2.50)
                ,new Drink("Caffè",3,1)
        );

    }


    @Bean
    public List<Antipasti> getAntipasti(){
        return List.of(new Antipasti("Supplì classico",100,2)
                ,new Antipasti("Supplì amatriciana",100,2.50)
                ,new Antipasti("Supplì carbonara",100,2.50)
                ,new Antipasti("Fiore di zucca",100,3.50)
                ,new Antipasti("Frittatina di pasta",250,5)
                ,new Antipasti("Anelli di cipolla fritti",500,3.50)
                ,new Antipasti("Fritto misto della casa",700,9)
                ,new Antipasti("Bruschetta pomodoro",30,1.50)
                ,new Antipasti("Bruschetta crostino",30,2)
                ,new Antipasti("Bruschetta verdure",30,2)
                ,new Antipasti("Tris di bruschette",300,4)
        );
    }


}
