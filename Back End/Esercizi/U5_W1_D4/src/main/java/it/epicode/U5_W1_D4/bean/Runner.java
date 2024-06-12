package it.epicode.U5_W1_D4.bean;


import it.epicode.U5_W1_D4.U5W1D4Application;
import it.epicode.U5_W1_D4.service.DispositivoService;
import it.epicode.U5_W1_D4.service.StudenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class Runner implements CommandLineRunner{
    @Autowired
    private StudenteService studenteService;

    @Autowired
    private DispositivoService dispositivoService;

    @Override
    public void run(String... args) throws Exception {


        ApplicationContext ctx = new AnnotationConfigApplicationContext(U5W1D4Application.class);
/*
        Studente studente1 = ctx.getBean("Simone", Studente.class);
        studenteService.inserisciStudente(studente1);

        Studente studente2 = ctx.getBean("Mario", Studente.class);
        studenteService.inserisciStudente(studente2);

        Computer computer = ctx.getBean(Computer.class);
        computer.setStudente(studente1);
        dispositivoService.inserisciDispositivo(computer);

        Smartphone smartphone = ctx.getBean(Smartphone.class);
        smartphone.setStudente(studente2);
        dispositivoService.inserisciDispositivo(smartphone);

*/

        System.out.println(studenteService.getStudentiByNomeAndCognome("Simone","Castelluccio"));

        System.out.println(studenteService.getNomeByLike("%i%"));

        System.out.println(dispositivoService.getDispositiviByRamMinore(17));

        System.out.println(dispositivoService.getDispositiviByOrderNome());

    }
}
