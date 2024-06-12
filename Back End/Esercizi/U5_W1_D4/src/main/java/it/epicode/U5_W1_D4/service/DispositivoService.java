package it.epicode.U5_W1_D4.service;

import it.epicode.U5_W1_D4.bean.Dispositivo;
import it.epicode.U5_W1_D4.repository.DispositivoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DispositivoService {


    @Autowired
    private DispositivoRepository dispositivoRepository;

    public void inserisciDispositivo(Dispositivo dispositivo){
        dispositivoRepository.save(dispositivo);
    }



    public Dispositivo getDispositivo(int matricola){
        return dispositivoRepository.findById(matricola).get();
    }



    public List<Dispositivo> getDispositivi(){
        return dispositivoRepository.findAll();
    }


    public void cancellaDispositivo(int matricola){
        dispositivoRepository.deleteById(matricola);
    }

    public List<Dispositivo> getDispositiviByRamMinore (int ram){
        return dispositivoRepository.findByRamLessThan(ram);
    }

    public List<Dispositivo> getDispositiviByOrderNome(){
        return dispositivoRepository.findAllOrderByNomeDesc();
    }

}
