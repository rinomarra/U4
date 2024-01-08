import java.util.Arrays;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Moltiplicazione {
    public static void main(String[] args) {
        int a = 20;
        int b = 50;
        int result = multiply(a, b);
        System.out.println(result);

        System.out.println(concat("bla", 6));

        String[] arr = insertIntoArray(new String[]{"A", "B", "C", "D", "E"}, "aaaaa");

        System.out.println(Arrays.toString(arr));
    }

    //Metodo Moltiplica
    public static int multiply(int a, int b) {
        return a * b;
    }

    public static String concat(String str, int num) {
        return str + num;
    }

    public static String[] insertIntoArray(String[] stringArray, String str) {
        String[] array = new String[6];
        for (int i = 0; i < stringArray.length +1 ; i++) {
            if(i < 2) {
                array[i] = stringArray[i];
            } else if(i == 2) {
                array[i] = str;
            } else {
                array[i] = stringArray[i - 1];
            }
        }

        return array;
    }

}