package it.epicode.be.classi.base;

import it.epicode.be.classi.interfacce.RegolazioneVolume;

public abstract class ElementoMultimedialeRiproducibile extends ElementoMultimediale implements RegolazioneVolume {
    protected int durata = 0;
    protected int volume = 0;

    protected ElementoMultimedialeRiproducibile(String titolo, int durata, int volume) {
        super(titolo);
        this.durata = durata;
        this.volume = volume;
    }

    public abstract void play();

    public int alzaVolume() {
        this.volume = volume + 1;
        return this.volume;
    }

    public int abbassaVolume() {
        // Controlla che il volume non sia già a 0
        if (this.volume > 0) {
            this.volume = volume - 1;
        }
        return this.volume;
    }

    protected String creaStringaRiproduzione() {
        String riproduzione = this.titolo;

        // Aggiunge ! corrispondenti al volume
        for (int i = 0; i < this.volume; i++) {
            riproduzione += "!";
        }

        return riproduzione;

    }
}
