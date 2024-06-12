package it.epicode.u5w1d4esercizio.service;


import it.epicode.u5w1d4esercizio.bean.Menu;
import it.epicode.u5w1d4esercizio.bean.Pizze;
import it.epicode.u5w1d4esercizio.repository.MenuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MenuService {
    @Autowired
    private MenuRepository menuRepository;

    public void salvaMenu(Menu menu){
        menuRepository.save(menu);
    }

    public List<Pizze> getPizzePriceLessThan(double prezzo){
     return menuRepository.findByPrezzoLessThan(prezzo);
    }

    public long countPizze(){
        return menuRepository.countPizze();
    }



}
