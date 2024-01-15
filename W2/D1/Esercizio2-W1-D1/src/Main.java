import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        try {
            System.out.print("Inserire i kilometri percorsi: ");
            int km = scanner.nextInt();
            System.out.print("Inserire i litri di benzina consumati: ");
            double liters = scanner.nextInt();
            /*
             * un float non è da intendersi come una rappresentazione esatta di un numero
             * (com'è invece un int), ma solo come una rappresentazione approssimata. Dunque
             * il float 0f non rappresenta lo zero, ma un numero sufficientemente piccolo in
             * valore assoluto da non poter essere risolto in una rappresentazione diversa
             * da zero. Dunque per i float la divisione per zero "non esiste".
             */
            double kmLiter = km / liters;
            //double = Double;
            //classe Wrapper
            if (Double.isInfinite(kmLiter)) {
                throw new ArithmeticException("Non si può dividere per zero!");
            }

            System.out.println("L'auto percorre " + kmLiter + "km al litro");


        } catch (ArithmeticException e) {
            System.out.println("Impossibile che la tua macchina non consumi carburante, controlla i litri inseriti");
            // Stampa in console lo stacktrace dell'eccezione
            e.printStackTrace();
        } finally {
            scanner.close();
        }
    }
}