package it.epicode.be.rettangolo;

public class Rettangolo {
    private double altezza;
    private double larghezza;

    public static int statica;
    //costruttore
    public Rettangolo(double alt, double larg) {
        this.altezza = alt;
        this.larghezza = larg;
        statica++;
    }

    public double area() {
        return altezza * larghezza;
    }

    public double perimetro() {
        metodoStatico();
        return (altezza + larghezza) * 2;
    }

    //metodo di classe
    public static void metodoStatico(){
        //funzionalità
        System.out.println("questo è un metodo static");
    }
    public final void display(){
        //funzionalità
        System.out.println("questo è un metodo static");
    }
}
