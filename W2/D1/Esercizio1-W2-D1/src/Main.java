import java.util.Random;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int num, position;
        boolean continua = true;
        int[] arr = getRandomArray();
        do {
            System.out.println("Inserire un numero seguito dal tasto Invio. Inserire 0 per uscire");
            num = in.nextInt();
            if (num != 0) {
                System.out.println("Inserire la posizione in cui inserire il numero seguita dal tasto Invio");
                position = in.nextInt();
                try {
                    arr[position] = num;
                    printArray(arr);
                } catch (ArrayIndexOutOfBoundsException e) {
                    System.out.println("Posizione fuori dal limite dell'array: " + position);
                }
            } else {
                continua = false;
            }
        } while (continua);

        in.close();
    }

    public static int[] getRandomArray() {
        int[] arr = new int[5];
        Random rnd = new Random();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = rnd.nextInt(1, 11);
        }
        return arr;
    }

    public static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.println("Valore posizione " + i + ": " + arr[i]);
        }

    }
}