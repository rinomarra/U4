package it.epicode.be.ecommerce;

public class Articolo {

    private String codice;
    private String descrizione;
    private double prezzo;
    private int numeroPezziInMagazzino;

    public Articolo(String codice, String descrizione, double prezzo) {
        this.codice = codice;
        this.descrizione = descrizione;
        this.prezzo = prezzo;
        this.numeroPezziInMagazzino = 0;
    }

    public String getCodice() {
        return codice;
    }

    public void setCodice(String codice) {
        this.codice = codice;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    public double getPrezzo() {
        return prezzo;
    }

    public void setPrezzo(double prezzo) {
        this.prezzo = prezzo;
    }

    public int getNumeroPezziInMagazzino() {
        return this.numeroPezziInMagazzino;
    }

    public void setNumeroPezziInMagazzino(int numeroPezziInMagazzino) {
        this.numeroPezziInMagazzino = numeroPezziInMagazzino;
    }

    public void aggiungiPezziAMagazzino(int numeroPezziDaAggiungere) {
        this.numeroPezziInMagazzino += numeroPezziDaAggiungere;
    }

    @Override
    public String toString() {
        return this.getCodice() + " " + this.getPrezzo() + " --> " + this.getNumeroPezziInMagazzino();
    }
}
