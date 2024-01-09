package it.epicode.be.automobile;

import it.epicode.be.carrozzeria.Telaio;
import it.epicode.be.motore.BloccoMotore;

public class Automobile {
    //attributo o stato
    private Telaio telaio;
    private BloccoMotore motore;

    public boolean batteriaCarica = false;

    public Automobile(int cilindrata, String numeroMatricola){
        this.motore = new BloccoMotore(cilindrata);
        this.telaio = new Telaio(numeroMatricola);
    }

    public void avviaMotore(){
        if (batteriaCarica){
            accendiMotore();
        }
    }

    public String accendiMotore(){
        return "acceso";
    }

}
