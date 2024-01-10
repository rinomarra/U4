import it.epicode.be.esercitazione.Automobile;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        System.out.printf("Esercitazione D3");
        Automobile[] autoArray = new Automobile[5];

        //istanza
        Automobile auto1 = new Automobile(1100, "XYZ");
        Automobile auto2 = new Automobile(false);
        Automobile auto3 = new Automobile(1500, "ZZZ");
        Automobile auto4 = auto1;
        autoArray[0] = auto1;
        autoArray[1] = new Automobile(1600, "TTT");
        boolean confronto1 = (auto1 == auto3);
        boolean confronto2 = (auto1 == auto4);
        boolean confronto3 = auto1.equals(auto3);
        boolean confronto4 = auto1.equals(auto4);
        int tempGetcilindrata = auto1.getCilindrataMotore();
        auto1.setTarga("XRT");
        auto3.setTarga("FFF");
        int variabileDiClasseMetodo = Automobile.getNumeroRuote();
        int variabileDiClasseVariabile = Automobile.valoreDiClasse;
        auto4.setTarga("CCC");
        System.out.println(tempGetcilindrata);
        System.out.println("Confronto1 fra auto1 e auto3 "+confronto1);
        System.out.println("Confronto2 fra auto1 e auto4 "+confronto2);
        System.out.println("Confronto3 fra auto1 e auto3 "+confronto3);
        System.out.println("Confronto4 fra auto1 e auto4 "+confronto4);
        System.out.println("Targa Auto1 "+auto1.getTarga());
        System.out.println("Targa Auto4 "+auto4.getTarga());

    }
}