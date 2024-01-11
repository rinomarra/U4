package it.epicode.be.classibase;

import it.epicode.be.classienum.Dipartimento;
import it.epicode.be.classienum.Livello;

public class Dipendente {
    public static double stipendioBase = 1000;
    private String matricola;
    private double stipendio;
    private double importoOrarioStraordinario;
    private Livello livello;
    private Dipartimento dipartimento;

    public Dipendente(String matricola, Dipartimento dipartimento) {
        this.matricola = matricola;
        this.dipartimento = dipartimento;
        this.stipendio = Dipendente.stipendioBase;
        this.importoOrarioStraordinario = 30;
        this.livello = Livello.OPERAIO;
    }

    public Dipendente(String matricola, Dipartimento dipartimento, double stipendio, double importoOrarioStraordinario,
                      Livello livello) {
        this(matricola, dipartimento);
        this.stipendio = stipendio;
        this.importoOrarioStraordinario = importoOrarioStraordinario;
        this.livello = livello;
    }

    public String getMatricola() {
        return matricola;
    }

    public double getStipendio() {
        return stipendio;
    }

    public double getImportoOrarioStraordinario() {
        return importoOrarioStraordinario;
    }

    public Livello getLivello() {
        return livello;
    }

    public void setImportoOrarioStraordinario(double importoOrarioStraordinario) {
        this.importoOrarioStraordinario = importoOrarioStraordinario;
    }

    public Dipartimento getDipartimento() {
        return dipartimento;
    }

    public void setDipartimento(Dipartimento dipartimento) {
        this.dipartimento = dipartimento;
    }

    public void stampaDatiDipendente() {
        System.out.println("Matricola: " + this.matricola);
        System.out.println("Stipendio: " + this.stipendio);
        System.out.println("Livello: " + this.livello);
        System.out.println("Dipatrimento: " + this.dipartimento);
        System.out.println("Importo orario straordinario: " + this.importoOrarioStraordinario);
    }

    public void promuovi() {

        if (this.livello == Livello.OPERAIO) {
            this.livello = Livello.IMPIEGATO;
            this.stipendio = Dipendente.stipendioBase * 1.2;
        } else if (this.livello == Livello.IMPIEGATO) {
            this.livello = Livello.QUADRO;
            this.stipendio = Dipendente.stipendioBase * 1.5;
        } else if (this.livello == Livello.QUADRO) {
            this.livello = Livello.DIRIGENTE;
            this.stipendio = Dipendente.stipendioBase * 2;
        } else {
            System.out.println("Impossibile promuovere, il dipendente [" + this.getMatricola() + "] è già dirigente");
        }
    }

    public static double calcolaPaga(Dipendente dipendente) {
        return dipendente.getStipendio();
    }

    public static double calcolaPaga(Dipendente dipendente, int oreStraordinario) {
        double stipendio = dipendente.getStipendio();
        double straordinario = dipendente.getImportoOrarioStraordinario() * oreStraordinario;
        return stipendio + straordinario;
    }

}
