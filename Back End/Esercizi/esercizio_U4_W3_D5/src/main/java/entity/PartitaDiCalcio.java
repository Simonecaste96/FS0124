package entity;

import enums.TipoEvento;

import javax.persistence.Column;
import java.time.LocalDate;

public class PartitaDiCalcio extends Evento {
    @Column(name = "squadra_casa", nullable = false)
    private String squadraCasa;
    @Column(name = "squadra_ospite", nullable = false)
    private String squadraOspite;
    @Column(name = "squadra_vincente", nullable = false)
    private String squadraVincente;
    @Column(name = "gol_casa", nullable = false)
    private int GolSquadraCasa;
    @Column(name = "gol_ospite", nullable = false)
    private int GolSquadraOspite;

    public PartitaDiCalcio(int id, String titolo, LocalDate dataEvento, String descrizione, TipoEvento tipoEvento, int numeroMassimoPartecipanti, String squadraCasa, String squadraOspite, String squadraVincente, int golSquadraCasa, int golSquadraOspite) {
        super(id, titolo, dataEvento, descrizione, tipoEvento, numeroMassimoPartecipanti);
        this.squadraCasa = squadraCasa;
        this.squadraOspite = squadraOspite;
        this.squadraVincente = squadraVincente;
        GolSquadraCasa = golSquadraCasa;
        GolSquadraOspite = golSquadraOspite;
    }

    public PartitaDiCalcio(String squadraCasa, String squadraOspite, String squadraVincente, int golSquadraCasa, int golSquadraOspite) {
        this.squadraCasa = squadraCasa;
        this.squadraOspite = squadraOspite;
        this.squadraVincente = squadraVincente;
        GolSquadraCasa = golSquadraCasa;
        GolSquadraOspite = golSquadraOspite;
    }

    public PartitaDiCalcio() {
    }

    public String getSquadraCasa() {
        return squadraCasa;
    }

    public void setSquadraCasa(String squadraCasa) {
        this.squadraCasa = squadraCasa;
    }

    public String getSquadraOspite() {
        return squadraOspite;
    }

    public void setSquadraOspite(String squadraOspite) {
        this.squadraOspite = squadraOspite;
    }

    public String getSquadraVincente() {
        return squadraVincente;
    }

    public void setSquadraVincente(String squadraVincente) {
        this.squadraVincente = squadraVincente;
    }

    public int getGolSquadraCasa() {
        return GolSquadraCasa;
    }

    public void setGolSquadraCasa(int golSquadraCasa) {
        GolSquadraCasa = golSquadraCasa;
    }

    public int getGolSquadraOspite() {
        return GolSquadraOspite;
    }

    public void setGolSquadraOspite(int golSquadraOspite) {
        GolSquadraOspite = golSquadraOspite;
    }

    @Override
    public String toString() {
        return "PartitaDiCalcio{" +
                "squadraCasa='" + squadraCasa + '\'' +
                ", squadraOspite='" + squadraOspite + '\'' +
                ", squadraVincente='" + squadraVincente + '\'' +
                ", GolSquadraCasa=" + GolSquadraCasa +
                ", GolSquadraOspite=" + GolSquadraOspite +
                '}';
    }
}
