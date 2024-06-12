package it.progetto.u5w2d5.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import it.progetto.u5w2d5.enums.StatoDispositivo;
import it.progetto.u5w2d5.enums.TipoDispositivo;
import jakarta.persistence.*;
import lombok.Data;


@Entity
@Data
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "dispositivi")
//@DiscriminatorColumn(name = "dispositivo", discriminatorType = DiscriminatorType.STRING)
public  class Dispositivo {
    @Id
    @GeneratedValue
    private int id;


    private String modello;

    private String marca;

    @Enumerated(EnumType.STRING)
    private StatoDispositivo statoDispositivo;

    @Enumerated(EnumType.STRING)
    private TipoDispositivo tipoDispositivo;

    @ManyToOne()
    @JoinColumn(name = "dipendente_id")
    @JsonIgnore
    private Dipendente dipendente;


}
