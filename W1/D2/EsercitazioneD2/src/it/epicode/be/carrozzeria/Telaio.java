package it.epicode.be.carrozzeria;

public class Telaio {
    //Attributi o stati
    //Variabile d'istanza
    private String numeroMatricola;
    //un costruttore che può essere anche di default ( cioè senza definizione )
    public Telaio(String numeroMatricola){
        this.numeroMatricola = numeroMatricola;
    }
    //opzionale i getters
    public String getNumeroMatricola() {
        return numeroMatricola;
    }
}
