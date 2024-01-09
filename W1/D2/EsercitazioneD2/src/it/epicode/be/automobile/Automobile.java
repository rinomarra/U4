package it.epicode.be.automobile;

import it.epicode.be.carrozzeria.Telaio;
import it.epicode.be.motore.BloccoMotore;

public class Automobile {
    //attributo o stato
    private Telaio telaio;
    private BloccoMotore motore;
    public boolean batteriaCarica;

    public Automobile(){ }

    public Automobile(int cilindrata, String numeroMatricola){
        this.motore = new BloccoMotore(cilindrata);
        this.telaio = new Telaio(numeroMatricola);
    }
    //primo esempio con costruttore per il problema della traccia è questo
    public Automobile(boolean batteriaCarica){
        this.batteriaCarica = batteriaCarica;
    }
    public Automobile(int cilindrata, String numeroMatricola, boolean batteriaCarica){
        this.motore = new BloccoMotore(cilindrata);
        this.telaio = new Telaio(numeroMatricola);
        this.batteriaCarica = batteriaCarica;
    }

    public void avviaMotore(){
        if (batteriaCarica){
            accendiMotore();
        }
    }

    public String accendiMotore(){
        return "acceso";
    }

    public boolean isBatteriaCarica() {
        return batteriaCarica;
    }
    //Setters (opzionale)
    public void setBatteriaCarica(boolean batteriaCarica) {
        this.batteriaCarica = batteriaCarica;
    }
}
