package it.epicode.be.classiconcrete;

import it.epicode.be.classebase.Veicolo;
import it.epicode.be.interfaces.Connettibile;
import it.epicode.be.interfaces.Ricaricabile;

public class Automobile extends Veicolo implements Ricaricabile, Connettibile {
    private final int numeroRuote = 4;

    public Automobile(String marca, String modello) {
        super(marca, modello);
    }

    public Automobile(int numeroPosti) {
        super(numeroPosti);
    }

    public int getNumeroRuote() {
        return numeroRuote;
    }

    @Override
    public void stampaDettagli() {
        System.out.println("Automobile: "+ super.getMarca() +" modello: "+ super.getModello());
    }

    @Override
    public String getMarca() {
        return "la marca della mia automobile è: "+getMarca();
    }



    public String getMarca(String test) {
        return "la marca della mia automobile è: "+getMarca()+" parametro esterno: "+test;
    }

    @Override
    public void ricarica() {
        System.out.println("Automobile in ricarica");
    }

    @Override
    public void connetti() {
        System.out.println("Automobile connessa");
    }

    @Override
    public void disconnetti() {
        System.out.println("Automobile disconnessa");
    }
}
