package it.epicode.be.classi.concrete;

import it.epicode.be.classi.base.ElementoMultimedialeRiproducibile;
import it.epicode.be.classi.interfacce.RegolazioneLuminosa;

public class Video extends ElementoMultimedialeRiproducibile implements RegolazioneLuminosa {
    private int luminosita = 0;

    public Video(String titolo, int durata, int volume, int luminosita) {
        super(titolo, durata, volume);
        this.luminosita = luminosita;
    }

    @Override
    public int alzaLuminosita() {
        this.luminosita = luminosita + 1;
        return this.luminosita;
    }

    @Override
    public int abbassaLuminosita() {
        // Controlla che la luminosita' non sia già a 0
        if (this.luminosita > 0) {
            this.luminosita = luminosita - 1;
        }
        return this.luminosita;
    }

    @Override
    public void play() {
        String riproduzione = creaStringaRiproduzione();

        // Aggiunge gli * corrispondenti alla luminosita'

        for (int j = 0; j < this.luminosita; j++) {
            riproduzione += "*";
        }

        // Scrive la stringa un numero di volte pari alla durata
        for (int k = 1; k <= this.durata; k++) {
            System.out.println("Video: " + k + " - " + riproduzione);
        }

    }
}
