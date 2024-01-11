package it.epicode.be.telefonia;

public class Chiamata {
    private String numeroChiamato;
    private int durata;

    public Chiamata(String numChiamato, int durata) {
        this.numeroChiamato = numChiamato;
        this.durata = durata;
    }

    public String getNumeroChiamato() {
        return this.numeroChiamato;
    }

    public int getDurata() {
        return this.durata;
    }
}
