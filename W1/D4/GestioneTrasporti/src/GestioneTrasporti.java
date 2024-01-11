import it.epicode.be.classebase.Veicolo;
import it.epicode.be.classiconcrete.Automobile;
import it.epicode.be.classiconcrete.Bicicletta;

import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class GestioneTrasporti {
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        System.out.println("Gestione Trasporti");
        Scanner scanner = new Scanner(System.in);
        Veicolo[] veicoli = {new Automobile("Fiat", "500"), new Bicicletta("Bianchi", "Pista")};
        Veicolo[] veicolo1 = new Veicolo[2];
        veicolo1[0] = new Automobile("Fiat", "500");
        veicolo1[1] = new Bicicletta("Bianchi", "Pista");
        while(true){
            System.out.println("Scegli un veicolo (1-Auto, 2 Bicicletta, 0-Esci)");
            int scelta = scanner.nextInt();
            if(scelta == 0) break;
            if(scelta >= 1 && scelta <= 2) {
                veicoli[scelta-1].stampaDettagli();
            } else {
                System.out.println("Scelta non valida");
            }
        }
        scanner.close();

        /*Veicolo veicolo1 = new Automobile("Fiat", "Panda");
        Veicolo veicolo2 = new Automobile("Ferrari", "F40");
        Veicolo veicolo3 = new Automobile("Fiat", "Panda");
        Veicolo veicolo4 = new Bicicletta("Bmx", "Bxm100");
        if(veicolo1.equals(veicolo3)){
            System.out.println("I veicolo sono uguali");
        } else {
            System.out.println("non sono uguali");
        }
        if(veicolo1 instanceof Veicolo){
            System.out.println("La classe è di tipo Test");
        } else {
            System.out.println("La classe non è di tipo Test");
        }
        //Automobile
        veicolo1.stampaDettagli();
        //Bicicletta
        veicolo4.stampaDettagli();
        //System.out.println(veicolo1.toString());*/
    }
}

