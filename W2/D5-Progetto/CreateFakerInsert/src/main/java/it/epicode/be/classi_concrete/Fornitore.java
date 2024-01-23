package it.epicode.be.classi_concrete;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
@Data
public class Fornitore {
    private int numeroFornitore;
    private String denominazione;
    private String regioneResidenza;
    // + getters, setters e costruttore
}
