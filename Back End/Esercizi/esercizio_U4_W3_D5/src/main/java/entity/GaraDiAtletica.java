package entity;

import enums.TipoEvento;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

@Entity
public class GaraDiAtletica extends Evento {
    @ManyToMany(mappedBy = "gareDiAtletica")
    private Set<Persona> atleti;

    @ManyToOne
    @JoinColumn(name = "vincitore_id")
    private Persona vincitore;


    public GaraDiAtletica(int id, String titolo, LocalDate dataEvento, String descrizione, TipoEvento tipoEvento, int numeroMassimoPartecipanti, Set<Persona> atleti, Persona vincitore) {
        super(id, titolo, dataEvento, descrizione, tipoEvento, numeroMassimoPartecipanti);
        this.atleti = atleti;
        this.vincitore = vincitore;
    }

    public GaraDiAtletica(Set<Persona> atleti, Persona vincitore) {
        this.atleti = atleti;
        this.vincitore = vincitore;
    }

    public GaraDiAtletica(){}

    public Set<Persona> getAtleti() {
        return atleti;
    }

    public void setAtleti(Set<Persona> atleti) {
        this.atleti = atleti;
    }

    public Persona getVincitore() {
        return vincitore;
    }

    public void setVincitore(Persona vincitore) {
        this.vincitore = vincitore;
    }

    @Override
    public String toString() {
        return "GaraDiAtletica{" +
                "atleti=" + atleti +
                ", vincitore=" + vincitore +
                '}';
    }
}
