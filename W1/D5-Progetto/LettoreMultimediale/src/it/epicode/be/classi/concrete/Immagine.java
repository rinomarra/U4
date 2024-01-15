package it.epicode.be.classi.concrete;

import it.epicode.be.classi.base.ElementoMultimediale;
import it.epicode.be.classi.interfacce.RegolazioneLuminosa;

public class Immagine extends ElementoMultimediale implements RegolazioneLuminosa {
    private int luminosita = 0;

    public Immagine(String titolo, int luminosita) {
        super(titolo);
        this.luminosita = luminosita;
    }

    @Override
    public int alzaLuminosita() {

        this.luminosita = luminosita + 1;
        return this.luminosita;
    }

    @Override
    public int abbassaLuminosita() {

        // Controlla che la luminosità non sia già a 0
        if (this.luminosita > 0) {
            this.luminosita = luminosita - 1;
        }
        return this.luminosita;
    }

    public void show() {
        String visualizzazione = this.titolo;

        for (int i = 0; i < luminosita; i++) {
            visualizzazione += "*";
        }

        System.out.print("Immagine: " + visualizzazione);

    }
}
