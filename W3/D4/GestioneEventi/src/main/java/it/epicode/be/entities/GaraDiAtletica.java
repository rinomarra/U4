package it.epicode.be.entities;

import it.epicode.be.enumerations.TipoEvento;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

@Entity
@Table(name = "gare_di_atletica")
@NamedQuery(name = "gare_per_vincitore", query = "SELECT g FROM GaraDiAtletica g WHERE vincitore=:vincitore")
public class GaraDiAtletica extends Event {
    @ManyToMany
    @JoinTable(name = "gara_persona",
            joinColumns = @JoinColumn(name = "gara_id"),
            inverseJoinColumns = @JoinColumn(name = "atleta_id"))
    private Set<Person> atleti;

    @ManyToOne
    @JoinColumn(name = "vincitore")
    private Person vincitore;

    public GaraDiAtletica() {
    }

    public GaraDiAtletica(String titolo, LocalDate dataEvento, String descrizione,
                          TipoEvento tipoEvento,
                          int numeroMassimoPartecipanti, Location location) {
        super(titolo, dataEvento, descrizione, tipoEvento, numeroMassimoPartecipanti, location);
    }

    public Set<Person> getAtleti() {
        return atleti;
    }

    public void setAtleti(Set<Person> atleti) {
        this.atleti = atleti;
    }

    public Person getVincitore() {
        return vincitore;
    }

    public void setVincitore(Person vincitore) {
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
