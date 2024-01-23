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
public class Prodotto {
    private int idProdotto;
    private String descrizione;
    private boolean inProduzione;
    private boolean inCommercio;
    private LocalDate dataAttivazione;
    private LocalDate dataDisattivazione;
}
