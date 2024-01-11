import it.epicode.be.rettangolo.Rettangolo;
//import it.epicode.be.rettangolo.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    //Attributi chiamati anche stati della classe
    private int testNumero;

    //metodi che sono le funzionalità della mia classe
    public static void main(String[] args) {
        //se il metodo è static
        Rettangolo.metodoStatico();

        System.out.println("*********** Stampa rettangolo ***********");
        //il metodo non è static devo instanziare la classe
        //Rettangolo r1 è una variabile
        System.out.println("Variabile statica con nessuna instanza: "+Rettangolo.statica);
        Rettangolo r1 = new Rettangolo(20, 5.7);
        //int testStatico = Rettangolo.statica;
        System.out.println("Variabile statica primo utilizzo: "+Rettangolo.statica);
        stampaRettangolo(r1);
        System.out.println("*********** Stampa due rettangoli ***********");
        Rettangolo r2 = new Rettangolo(12, 40.2);
        System.out.println("Variabile statica secondo utilizzo: "+Rettangolo.statica);
        stampaDueRettangoli(r1, r2);
    }
    //metodi che sono le funzionalità della mia classe
    public static void stampaRettangolo(Rettangolo rettangolo) {
        System.out.println("Perimetro rettangolo: " + rettangolo.perimetro());
        System.out.println("Area rettangolo: " + rettangolo.area());
    }

    public static void stampaDueRettangoli(Rettangolo rettangolo1, Rettangolo rettangolo2) {

        System.out.println("Rettangolo 1: ");
        stampaRettangolo(rettangolo1);

        System.out.println("Rettangolo 2: ");
        stampaRettangolo(rettangolo2);

        double sommaAree = rettangolo1.area() + rettangolo2.area();
        double sommaPerimetri = rettangolo1.perimetro() + rettangolo2.perimetro();

        System.out.println("Somma perimetri: ");
        System.out.println(sommaPerimetri);

        System.out.println("Somma aree: ");
        System.out.println(sommaAree);

    }
}
//qualificatore di default
class Quadrato {

}