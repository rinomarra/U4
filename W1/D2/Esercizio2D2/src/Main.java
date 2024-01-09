import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        Scanner scan = new Scanner(System.in);
        int test = scan.nextInt();
        System.out.println(stampaNumero(test));
        scan.close();
    }

    public static String stampaNumero(int num) {
        String risultato;
        switch (num) {
            case 0: {
                risultato = "zero";
                break;
            }
            case 1: {
                risultato = "uno";
                break;
            }
            case 2: {
                risultato = "due";
                break;
            }
            case 3: {
                risultato = "tre";
                break;
            }
            default:
                risultato = "Numero non compreso tra 0 e 3, impossibile convertire";
        }
        return risultato;
    }
}