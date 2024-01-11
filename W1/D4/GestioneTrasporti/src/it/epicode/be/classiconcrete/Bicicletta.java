package it.epicode.be.classiconcrete;

import it.epicode.be.classebase.Veicolo;
import it.epicode.be.interfaces.Ricaricabile;

public class Bicicletta extends Veicolo implements Ricaricabile {
    private final int numeroRuote = 2;

    public Bicicletta(String marca, String modello) {
        super(marca, modello);
    }

    public Bicicletta(int numeroPosti) {
        super(numeroPosti);
    }

    public int getNumeroRuote() {
        return numeroRuote;
    }

    @Override
    public void stampaDettagli() {
        System.out.println("Bicicletta: " + getMarca() + " modello: "+getModello());
    }

    @Override
    public void ricarica() {
        System.out.println("La bicicletta è in fase di ricarica");
    }
}
