//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
//it.test.view


import it.primoprogetto.costanti.Day;
import it.primoprogetto.costanti.Week;

import java.util.Scanner;

/**
 * Documentazione
 * valida per javadoc
 */

public class Main {

    //dichiarazione
    public int numero;
    public int numeroSingolo;

    public char testChar = 'A';

    //public Auto arrayAuto [] = { }

    public final int numeroFinal = 0;
    public int numeroX, numeroUno, numeroDue = 10;
    //dichiarazione + assegnazione di un valore
    public static double numeroConVirgola;
    public static boolean vero = true;
    private static String testTest = "test";
    private static final String TEST_TEST = "test";
    private static final String TESTTEST  = "test";
    public static int numeroCaratteri = testTest.length();
    //Formalismo per le variabili
    //[qualificatore di visibilità (opzionale)] [dichiarazione (static | final :opzionali)] [tipo di dato] [identificativo]; dichiarazione di variabile

    //Formalismo per i metodi
    //[qualificatore di visibilità (opzionale)] [dichiarazione (static | final :opzionali)] [tipo di dato di ritorno] [identificativo]; dichiarazione di variabile
    //i parametri fra parentesi ([Tipo dato] [identificativo]... "separati da una virgola")
    // le parentesi { } tutto quello che c'è all'interno delle parentesi {} è il corpo del metodo
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        //Scanner
        System.out.println("Inserire una stringa " + "seguita dal tasto invio");
        //Variabile di tipo Scanner
        Scanner scanner = new Scanner(System.in);
        String inputTerminal = scanner.nextLine();
        System.out.println("la stringa inserita è: "+inputTerminal);
        System.out.println("Inserire un numero intero " + "seguito dal tasto invio");
        int intero = scanner.nextInt();
        System.out.println("Il numero inserito è: "+intero);



        // sto stampando a video una stringa
        int test = 0;
        System.out.println("Hello and welcome!"+ ": "+ testTest+ "test: "+test);
        System.out.println("Numero di caratteri della stringa test: "+numeroCaratteri);
        System.out.println(Day.LUNEDI);
        System.out.println(Week.PRIMOWEEK.getDescription());
        /*
        commenti
        multiriga
       */
        for (int i = 1; i <= 5; i++) {
            //TIP Press <shortcut actionId="Debug"/> to start debugging your code. We have set one <icon src="AllIcons.Debugger.Db_set_breakpoint"/> breakpoint
            // for you, but you can always add more by pressing <shortcut actionId="ToggleLineBreakpoint"/>.
            System.out.println("i = " + i);
        }
        System.out.println("----------------------------------------------------------------------");
        String[] stagioni;
        stagioni = new String[4];
        stagioni[0] = "prima";
        double[][] matrice = new double[3][12];

        final int ROW = 3;
        final int COL = 4;

        int[][] tavola = new int[ROW][COL];

        for (int i = 0; i < tavola.length; i++) {
            for (int j = 0; j < tavola[i].length; j++) {
                tavola[i][j] = (i+1)*(j+1);
            }
        }
        System.out.println("Lunghezza tavola: "+tavola.length);
        System.out.println("Indice 0:" + tavola[0].length);
        System.out.println("Valore indice [2][3]: "+tavola[2][3]);

    }

    public int somma(int a, int b){
        String risultato = "5";
        return a+b;

    }
}