package it.epicode.progettoU5_W1_D5.repository;

import it.epicode.progettoU5_W1_D5.beans.Postazione;
import it.epicode.progettoU5_W1_D5.enums.Tipo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PostazioneRepository extends JpaRepository<Postazione,Integer> {


   // DA TERMINARE

    List<Postazione> findByTipoPostazioneAndEdificio_Citta(Tipo tipoPostazione, String citta);

}
