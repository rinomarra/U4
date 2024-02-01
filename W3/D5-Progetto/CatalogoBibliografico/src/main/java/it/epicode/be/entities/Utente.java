package it.epicode.be.entities;


import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@Setter
@ToString
@NoArgsConstructor
@Entity
@Table(name = "utenti")
@NamedQuery(name = "utenteFindAll", query = "SELECT u FROM Utente u")
public class Utente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_utente")
    private long id;
    private String nome;
    private String cognome;
    @Column(name = "data_nascita")
    private LocalDate dataDiNascita;
    @Column(name = "tessera", nullable = false, unique = true)
    private Long numeroTessera;

    public Utente(String nome, String cognome, LocalDate dataDiNascita, Long numeroTessera) {
        this.nome = nome;
        this.cognome = cognome;
        this.dataDiNascita = dataDiNascita;
        this.numeroTessera = numeroTessera;
    }
}
