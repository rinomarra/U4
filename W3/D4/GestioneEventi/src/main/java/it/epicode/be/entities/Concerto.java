package it.epicode.be.entities;

import it.epicode.be.enumerations.Genere;
import it.epicode.be.enumerations.TipoEvento;

import javax.persistence.Column;
import javax.persistence.*;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.time.LocalDate;

@Entity
@Table(name = "concerti")
@NamedQuery(name = "get_concerti_in_streaming", query = "SELECT c FROM Concerto c WHERE c.inStreaming=:inStreaming")
public class Concerto extends Event {
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Genere genere;
    @Column(nullable = false)
    private boolean inStreaming;

    public Concerto() {
    }

    public Concerto(String titolo, LocalDate dataEvento, String descrizione, TipoEvento tipoEvento,
                    int numeroMassimoPartecipanti, Location location, Genere genere, boolean inStreaming) {
        super(titolo, dataEvento, descrizione, tipoEvento, numeroMassimoPartecipanti, location );
        this.genere = genere;
        this.inStreaming = inStreaming;
    }


    public Genere getGenere() {
        return genere;
    }

    public void setGenere(Genere genere) {
        this.genere = genere;
    }

    public boolean isInStreaming() {
        return inStreaming;
    }

    public void setInStreaming(boolean inStreaming) {
        this.inStreaming = inStreaming;
    }

    @Override
    public String toString() {
        return "Concerto{" +
                "id=" + getId() +
                ", genere=" + genere +
                ", in streaming=" + inStreaming +
                '}';
    }
}