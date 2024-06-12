package it.epicode.u5w1d4esercizio.repository;

import it.epicode.u5w1d4esercizio.bean.Menu;
import it.epicode.u5w1d4esercizio.bean.Pizze;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MenuRepository extends JpaRepository<Menu,Integer> {

    public List<Pizze> findByPrezzoLessThan(double prezzo);
    @Query("select count(p) from Pizza p")
    public long countPizze();
}
