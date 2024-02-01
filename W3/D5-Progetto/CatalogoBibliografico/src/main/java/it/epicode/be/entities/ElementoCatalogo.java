package it.epicode.be.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@Entity
@Table(name = "catalogo_bibliografico")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@NamedQuery(name="elementoCatalogoFindAll", query = "SELECT a FROM ElementoCatalogo a")
@DiscriminatorColumn(name = "elementi_catalogo", discriminatorType = DiscriminatorType.STRING)
public class ElementoCatalogo {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name="id_isbn")
    private long isbn;
    private String titolo;
    @Column(name = "anno_pubblicazione")
    private int annoPublicazione;
    @Column(name = "numero_pagine")
    private int numeroPagine;
    @OneToOne
    private Prestito prestato;

    public ElementoCatalogo(String titolo, int annoPublicazione, int numeroPagine) {
        this.titolo = titolo;
        this.annoPublicazione = annoPublicazione;
        this.numeroPagine = numeroPagine;
    }
}
