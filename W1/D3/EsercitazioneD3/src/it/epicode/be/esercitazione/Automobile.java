package it.epicode.be.esercitazione;

public class Automobile {
    //Attributi
    //variabile di classe
    public static int valoreDiClasse = 5;
    private static int numeroRuote = 4;
    //Variabili d'istanza nascoste all'esterno della classe
    private int cilindrataMotore;
    private String targa;
    private boolean motoreAcceso = false;
    //protected
    protected String tipoDiAuto;


    //costruttore
    //signature del metodo = Automobile (int cilindrataMotore, String targa)
    public Automobile (int cilindrataMotore, String targa){
        this.cilindrataMotore = cilindrataMotore;
        this.targa = targa;
    }

    public Automobile (boolean motoreAcceso){
        this.motoreAcceso = motoreAcceso;
    }

    public int getCilindrataMotore() {
        String test = numeroMatricolaSpeciale();
        return cilindrataMotore;
    }
    //get + nome della variabile d'istanza rende la variabile leggibile all'esterno della classe
    public String getTarga() {
        return targa;
    }
    //set + nome variabile rende la variabile d'istanza scrivibile all'esterno della classe
    public void setTarga(String targa) {
        this.targa = targa;
    }

    //metodo di classe

    public static int getNumeroRuote() {
        return numeroRuote;
    }

    private String numeroMatricolaSpeciale(){
        return "matricola speciale";
    }
}
