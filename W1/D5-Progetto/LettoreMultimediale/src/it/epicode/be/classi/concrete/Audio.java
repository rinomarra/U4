package it.epicode.be.classi.concrete;

import it.epicode.be.classi.base.ElementoMultimedialeRiproducibile;

public class Audio extends ElementoMultimedialeRiproducibile {
    public Audio(String titolo, int durata, int volume) {
        super(titolo, durata, volume);
    }

    @Override
    public void play() {
        String riproduzione = creaStringaRiproduzione();

        // Scrive la stringa un numero di volte pari alla durata
        for (int k = 1; k <= this.durata; k++) {
            System.out.println("Audio: " + k + " - " + riproduzione);
        }
    }
}
