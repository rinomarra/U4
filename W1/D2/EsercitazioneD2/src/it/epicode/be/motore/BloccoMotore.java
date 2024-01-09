package it.epicode.be.motore;

public class BloccoMotore {

    //Attributo o stato
    private int cilindrata;
    //private int cilindrata = 1500;

    //costruttore (questo se dobbiamo inserire un valore iniziale alle variabili d'istanza)
    public BloccoMotore (int cilindrata){
        this.cilindrata = cilindrata;
    }
    //Getters (opzionale)
    public int getCilindrata() {
        return cilindrata;
    }
    //Setters (opzionale)
    public void setCilindrata(int cilindrata) {
        this.cilindrata = cilindrata;
    }
}
