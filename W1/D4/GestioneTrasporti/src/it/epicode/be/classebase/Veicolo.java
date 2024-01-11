package it.epicode.be.classebase;

public abstract class Veicolo {
    private String marca;
    private String  modello;

    protected int numeroPosti;

    //costruttore
    public Veicolo(String marca, String modello) {
        this.marca = marca;
        this.modello = modello;
    }

    public Veicolo(int numeroPosti){
        this.numeroPosti = numeroPosti;
    }

    public String getMarca() {
        return marca;
    }

    public String getModello() {
        return modello;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Veicolo veicolo = (Veicolo) obj;
        return marca.equals(veicolo.marca) && modello.equals(veicolo.modello);
        //return equals(obj);
    }

    @Override
    public String toString() {
        return "Veicolo{" +
                "marca='" + marca + '\'' +
                ", modello='" + modello + '\'' +
                ", numeroPosti=" + numeroPosti +
                '}';
    }

    public abstract void stampaDettagli();
}
