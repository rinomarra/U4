package it.epicode.be.entities;

import it.epicode.be.enumerators.Periodicita;
import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@Entity
public class Rivista extends ElementoCatalogo{
    @Enumerated(EnumType.STRING)
    private Periodicita periodicita;

    public Rivista(String titolo, int annoPublicazione, int numeroPagine, Periodicita periodicita) {
        super(titolo, annoPublicazione, numeroPagine);
        this.periodicita = periodicita;
    }
}
