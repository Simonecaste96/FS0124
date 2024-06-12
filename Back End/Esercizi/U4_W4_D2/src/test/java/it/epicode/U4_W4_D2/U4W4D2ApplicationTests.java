package it.epicode.U4_W4_D2;

import it.epicode.U4_W4_D2.bean.Aula;
import it.epicode.U4_W4_D2.bean.Studente;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootTest
class U4W4D2ApplicationTests {


    static ApplicationContext ctx; // CTX è STATICO

    //UN METODO STATICO LAVORA SOLO CON VARIABILI STATICHE
    @BeforeAll
    public static void accediAlContesto() { // ACCEDI AL CONTESTO è STATICO INFATTI
        ctx = new AnnotationConfigApplicationContext(U4W4D2Application.class);
        System.out.println("Accesso al contesto effettuato");
    }

    @Test
    void contextLoads() {
        Studente s1 = ctx.getBean("Simone", Studente.class);
        Assertions.assertEquals("Simone", s1.getNome());
    }

    @Test
    public void verificaAulaIsEmpty() {
        Aula aula = ctx.getBean(Aula.class);
        Assertions.assertNotNull(aula);  //Verifica se l'aula non è null
    }

    @Test
    public void verificaNumberStudenti() {
        Aula aula = ctx.getBean(Aula.class);
        Assertions.assertEquals(2, aula.getStudenti().size());      //Verifica se l'aula non è null
    }

    /*@ParameterizedTest //ANNOTAZIONE PER TEST CHE HANNO UN PARAMETRO
    @ValueSource(strings = {"C", "F", "S", "A", "B"})  //INSERISCO LE LETTERE DA
    public void verificaNumeroStudentiPerInizialeNome(String lettera) {
        Aula aula = ctx.getBean(Aula.class);
        aula.getStudenti().stream().filter(e->e.getNome().startsWith(lettera)).forEach(System.out::println);
        long conta = aula.getStudenti().stream().filter(e -> e.getNome().startsWith(lettera)).count();
        Assertions.assertEquals(1,conta);
    }*/

    @ParameterizedTest  //STA VOLTA PASSIAMO DUE PARAMETRI
    @CsvSource({"S,1","A,0","B,0"}) //OLTRE ALLA LETTERA INIZIALE, PASSO IL NUMERO DI STUDENTI CHE MI ASPETTO DITROVARE CON QUELLA LETTERA INIZIALE
    public void verificaNumeroStudentiPerInizialeNome(String lettera,int conteggio) {
        Aula aula = ctx.getBean(Aula.class);
        aula.getStudenti().stream().filter(e->e.getNome().startsWith(lettera)).forEach(System.out::println);
        long numero = aula.getStudenti().stream().filter(e -> e.getNome().startsWith(lettera)).count();
        Assertions.assertEquals(conteggio,numero);
    }

    @AfterAll
    public static void chiudiContesto() {
        ctx = null;
        System.out.println("Contesto chiuso");
    }

}
