package it.epicode.be.classi.base;

public abstract class ElementoMultimediale {
    protected String titolo;

    protected ElementoMultimediale(String titolo) {
        this.titolo = titolo;
    }

    public String getTitolo() {
        return titolo;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }
}
