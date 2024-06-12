package it.epicode.U5_W1_D4.repository;

import it.epicode.U5_W1_D4.bean.Dispositivo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface DispositivoRepository extends JpaRepository<Dispositivo,Integer> {


    //DERIVED QUERY
    public List<Dispositivo> findByRamLessThan(int ram);

//COSTUM QUERY
    @Query(value = "select d from Dispositivo d order by d.nome desc")
    public List<Dispositivo> findAllOrderByNomeDesc();
}
