import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        String input = "";
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.println("Inserire una stringa seguita dal tasto Invio");
            input = scanner.nextLine();
            /*
                Metodo .split(""): Questo metodo è usato per dividere una stringa in un array di sottostringhe
                 in base a un delimitatore specificato.
                 Il delimitatore è la stringa tra le virgolette nel metodo split. In questo caso, il delimitatore è una stringa vuota "", il che significa che la stringa input verrà divisa in tutte le posizioni dove c'è una stringa vuota, ovvero tra ogni coppia di caratteri.
            */
            String[] caratteri = input.split("");
            /*
                String.join è un metodo statico nella classe String che viene utilizzato per unire gli elementi di un array o di un elenco iterabile in una singola String.
                Il primo parametro, "delimiter", è una stringa che verrà utilizzata come separatore tra gli elementi durante la concatenazione. In questo caso, il delimitatore è una virgola ",".
                Il secondo parametro, elements, è l'array o l'elenco iterabile i cui elementi devono essere uniti. In questo esempio, caratteri è un array di stringhe.
             */
            System.out.println(String.join(",", caratteri));

        } while (!input.equals(":q"));
        scanner.close();
        System.out.println("Exit");
    }
}