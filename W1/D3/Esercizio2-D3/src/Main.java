import it.epicode.be.telefonia.Chiamata;
import it.epicode.be.telefonia.Sim;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Sim sim1 = new Sim("+39 3494278804");
        sim1.aggiungiCredito(20);
        //Variabile di tipo Chiamata ma di array
        Chiamata[] listaChiamate = new Chiamata[5];
        listaChiamate[0] = new Chiamata("+39 3494278805", 20);
        listaChiamate[1] = new Chiamata("+39 3494278805", 1);
        listaChiamate[2] = new Chiamata("+39 3494275405", 7);
        listaChiamate[3] = new Chiamata("+39 3494278876", 1);
        listaChiamate[4] = new Chiamata("+39 3494272358", 13);
        sim1.setListaChiamate(listaChiamate);
        sim1.stampaDati();
    }
}