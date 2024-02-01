package it.epicode.be.entities;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Libro extends ElementoCatalogo {
    private String autore;
    private String genere;

    public Libro(String titolo, int annoPublicazione, int numeroPagine, String autore, String genere) {
        super(titolo, annoPublicazione, numeroPagine);
        this.autore = autore;
        this.genere = genere;
    }
}
