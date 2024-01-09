import it.epicode.be.automobile.Automobile;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    private static Scanner scannerVariabileInstanza;
    public static void main(String[] args) {

        scannerVariabileInstanza = new Scanner(System.in);
        Scanner scanner = new Scanner(System.in);
        Automobile auto = new Automobile(1100,"XY5670", false);
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        System.out.println("Esercitazione D2");
        //chiedere all'utente di caricare la batteria
        System.out.println("La batteria è carica? (true/false) ");
        boolean statoBatteria = scanner.nextBoolean();
        auto.setBatteriaCarica(statoBatteria);
        auto.avviaMotore();

        if(auto.isBatteriaCarica()){
            System.out.println("Il motore è avviato");
        } else {
            System.out.println("Il motore non è avviato");
        }

        scanner.close();
        //per rendere la batteria carica cosa dobbiamo fare?
        //dobbiamo instanziare la classe Automobile
        // ************************************************* CONDIZIONALI ******************************************

       /*
        int x = 20, y = 30, z = 40;

        if (!(x > y)) {
            System.out.println("X è minore di Y");
        }
        else {
            System.out.println("X è maggiore di Y");
        }

        if (x > y) {
            System.out.println("X è maggiore di Y");
        } else if (x == 200) {
            System.out.println("X è uguale 100");
        } else {
            System.out.println("X è minore di Y ");
        }

        String result = x > y ? "X è maggiore di Y" : "X è minore di Y";
        System.out.println(result);

        int w = x > y ? (x > z ? x : z) : (y > z ? y : z); // Meglio non abusare del ternary operator per questioni di leggibilità
        System.out.println(w);*/
        //Break: Usato per uscire da un ciclo o un blocco `switch`.
        for (int i = 0; i < 10; i++) {
            if (i == 5) {
                break;  // Esce dal ciclo quando i è 5
            }
            System.out.println(i);
        }
        //Continue: Salta il resto del codice nel ciclo corrente e procede con la prossima iterazione.

        for (int i = 0; i < 10; i++) {
            if (i % 2 == 0) {
                continue;  // Salta i numeri pari
            }
            System.out.println(i);
        }

        //Return: Esce dal metodo corrente e, opzionalmente, restituisce un valore.




    }

    public static int square(int n) {
        return n * n;  // Restituisce il quadrato di n
    }

    // ******************************************** SWITCH-CASE **************************************************
/*        String favouriteColor = "green";
        String favouriteDish = "pizza";

        switch (favouriteColor) {
            case "red": {
                System.out.println("Il colore preferito è il rosso!");
                break;
            }
            case "yellow": {
                System.out.println("Il colore preferito è il giallo!");
                break;
            }
            case "blue": {
                System.out.println("Il colore preferito è il blu!");
                break;
            }
            default: {
                System.out.println("Il colore non è nè rosso nè giallo nè blu");
            }

        }*/

/*        if(favouriteDish.equals("pizza")){ <-- Quando si comparano due stringhe meglio usare ".equals" invece che "=="

        }*/

/*        int x = 10, y = 20;

        int z = (x > y) ? -100 : 100;

        switch (z) {
            case 10: {
                System.out.println("z é 10");
                x++;
                break;
            }
            case -100:{
                System.out.println("z é -100");
                break;
            }
            case 100: {
                System.out.println("z é 100");
                x--;
                break;
            }
            case 1000: {
                System.out.println("z é 1000");
                x--;
                break;
            }
            default: {
                System.out.println("Default");
                x--;
            }
        }

        System.out.println("X è " + x);*/

    // ***************************************** LOOPS **********************************
/*
        int x = 6, y = 3;

*//*        while (y <= x + 6) {
            System.out.println(y); // y = 12
            y += 3; // y = 15 quindi la condizione del while diventa falsa ed esco dal ciclo
        }*//*
     */
/*        int x = 6;
        do {
            System.out.println(x = x + 1);

        } while (x < 10);*/

    // System.out.println(x);

/*        for (int i = 1; i <= 10; i++) {
            if (i % 2 == 0) continue; // col continue saltiamo l'iterazione corrente e passiamo alla prossima
            System.out.println(i);
        }*/

/*        for (int i = 1; i <= 10; i++) {
            if (i == 6) break; // col break usciamo proprio dal loop
            System.out.println(i);
        }*/

}