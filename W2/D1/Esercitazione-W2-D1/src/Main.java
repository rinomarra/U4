import it.epicode.be.exceptions.InvalidStringException;

import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws InvalidStringException {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        System.out.println("Esercitazione W1 D1");
        //Eccezioni Unchecked
        /*
        int[] numbers = {1,2,3,4,5,6};
        //stampiamo l'array
        System.out.println(numbers[8]);

        String stringa = "test";
        //stringa = null;
        System.out.println(stringa.length());

        int num1 = 2;
        int num2 = 2;
        System.out.println(num1/num2);

        //Eccezioni Checked
        try {
            Thread.sleep(2); //esempio di CHECKED Exception
        } catch(InterruptedException e) {
            throw new RuntimeException(e);
        }
        String inputFormatScanner = "testuno";
        if(inputFormatScanner.length() < 3){
            System.out.println(inputFormatScanner);
        } else {
            throw new InvalidStringException("La stringa non è valida");
        }

        //throw new NumberLessThanZeroException(-100); //esempio di UNCHECKED
        try {
            int[] numbers = {1,2,3,4,5,6};
            //stampiamo l'array
            System.out.println(numbers[8]); //esempio di CHECKED Exception
        } catch(ArrayIndexOutOfBoundsException e) {
            throw new RuntimeException(e);
        }

        try {
            User aldo = new User("Aldo", "Test", 20);
            aldo.setName("A");
            System.out.println(aldo.getName());

        } catch (Exception ex){
            System.err.println(ex.getMessage());
            ex.printStackTrace();
        }
        */
        //Gestione errori
        try {
            int[] numbers = {1,2,3,4,5,6};
            //stampiamo l'array
            System.out.println(numbers[8]);
            String stringa = "test";
            stringa = null;
            int num1 = 2;
            int num2 = 2;
            System.out.println(num1/num2);

        } catch (ArrayIndexOutOfBoundsException ex){
            System.err.println(ex.getMessage());
        } catch (NullPointerException ex){
            System.err.println(ex.getMessage());
        } catch (ArithmeticException ex) {
            System.err.println(ex.getMessage());
        }

        Scanner input = new Scanner(System.in);

        try {
            System.out.println("Dammi il primo numero: ");
            int primo = Integer.parseInt(input.nextLine());

            System.out.println("Dammi il secondo numero: ");
            int secondo = Integer.parseInt(input.nextLine());

            try{
                System.out.println("Il risultato è: " + (primo/secondo));
            } catch (ArithmeticException ex){
                System.err.println(ex.getMessage());
            }

        } catch (Exception ex){
            System.err.println(ex.getMessage());
        } finally {
            input.close();
        }
    }
}