package it.epicode.be.classi_concrete;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@AllArgsConstructor
@Getter
@Setter
@Data
public class Cliente {
    private int numeroCliente;
    private String nome;
    private String cognome;
    private LocalDate dataNascita;
    private String regioneResidenza;
    // + getters, setters e costruttore
}
