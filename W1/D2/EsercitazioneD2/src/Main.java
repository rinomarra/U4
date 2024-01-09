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
}