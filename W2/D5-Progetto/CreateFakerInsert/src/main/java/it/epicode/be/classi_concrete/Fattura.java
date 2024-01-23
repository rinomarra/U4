package it.epicode.be.classi_concrete;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@AllArgsConstructor
@Getter
@Setter
public class Fattura {
    private int numeroFattura;
    private String tipologia;
    private double importo;
    private double iva;
    private int idCliente;
    private LocalDate dataFattura;
    private int numeroFornitore;
    // + getters, setters e costruttore
}
