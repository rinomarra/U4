//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        System.out.println("Esercizio#1");
        System.out.println("Stringa pari o dispari");
        if(stringaPariDispari("test")){
            System.out.println("String pari");
        } else {
            System.out.println("String dispari");
        }
        System.out.println("Anno bisestile");
        if(annoBisestile(2024)){
            System.out.println("L'anno inserito è bisestile");
        } else {
            System.out.println("L'anno inserito non è bisestile");
        }

    }

    public static boolean stringaPariDispari(String str) {
        return str.length() % 2 == 0 ? true : false;
    }

    public static boolean annoBisestile(int anno) {
        if (anno % 400 == 0) {
            return true;
        } else if (anno % 4 == 0 && anno % 100 != 0) {
            return true;
        } else {
            return false;
        }
    }
}