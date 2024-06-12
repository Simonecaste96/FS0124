package it.epicode.progettoSpring.appConfig;

import it.epicode.progettoSpring.bean.Aula;
import it.epicode.progettoSpring.bean.Computer;
import it.epicode.progettoSpring.bean.Smartphone;
import it.epicode.progettoSpring.bean.Studente;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;

import java.time.LocalDate;
import java.util.List;


//Creata la cassle di configurazione la annoto con @Configuration
@Configuration
public class AppConfig {


    //Fondamentale richiamare @Bean per poter creare le istantanze nel contesto
    @Bean(name = "Castelluccio")
    @Primary //-- posso usare anche queste annotazione senza inserire il nome ma resituirebbe sembra la stessa istanza
    @Scope(scopeName = "prototype") // Con lo scope prototype ci permette di ricevere un oggetto sempre differente quando richiedo questo bean (Scope di default: SingleTone)
    public Studente getStudente(){
        //metodo alternativo piu ridondante
        //Studente studente = new Studente("Castelluccio", LocalDate.of(1996,7,16),"Simone","Via Oder 11");
        //return studente;
        Studente studente1 = new Studente();
        studente1.setNome("Simone");
        studente1.setCognome("Castelluccio");
        studente1.setIndirizzo("Via Oder 11");
        studente1.setDataNascita(LocalDate.of(1996,7,16));
        studente1.setDispositivi(List.of(getComputer()));
       return studente1;

    }
    @Bean(name = "Alicante")
    public Studente getStudente2(){
        Studente studente2 = new Studente();
        studente2.setNome("Mario");
        studente2.setCognome("Andreucci");
        studente2.setIndirizzo("Via Carlo Cracco 3");
        studente2.setDataNascita(LocalDate.of(1949,3,2));
        studente2.setDispositivi(List.of(getComputer(),getSmartphone()));
return studente2;
    }
@Bean
    public Computer getComputer(){
        Computer computer = new Computer();
        computer.setMarca("Hp");
        computer.setModello("X1");
        computer.setProcessore("Intel 12 gen");
        computer.setRam(16);
        computer.setMemoriaSsd(1000);
return computer;
    }
@Bean
    public Smartphone getSmartphone(){
        Smartphone smartphone = new Smartphone();
        smartphone.setMarca("Apple");
        smartphone.setModello("14 Pro Max");
        smartphone.setColore("Red");
        smartphone.setMemoria(256);
        return smartphone;
    }
@Bean
    public Aula getAula(){
        Aula aula = new Aula();
        aula.setNome("C5");
        aula.setStudenti(List.of(getStudente(),getStudente2()));
        return aula;
    }
}
