package it.epicode.be.entities;

import java.util.Random;

public class Student {
    // Attributi statici
    public static String school = "Epicode";
    private int numeroPrivato;
    // qualificatore di default
    int testNumero;
    String surname;
    // se non metto niente non è nè private nè public, è PACKAGE-FRIENDLY
    // tutti quelle classi che stanno nello stesso package potranno accedervi
    private int id;
    // LISTA ATTRIBUTI
    private TipoStudente tipo = TipoStudente.FULLSTACK;
    private String name;
    // LISTA COSTRUTTORI

    // Costruttore I
    public Student() {
        Random rndm = new Random();
        this.name = "NOME DI DEFAULT";
        this.surname = "COGNOME DI DEFAULT";
        this.id = rndm.nextInt(1, 10000);
    }

    // Costruttore II
    public Student(String name) {
        Random rndm = new Random();
        this.name = name;
        this.surname = "COGNOME DI DEFAULT";
        this.id = rndm.nextInt(1, 10000);
    }

    // Costruttore III
    public Student(String name, String surname) {
        Random rndm = new Random();
        this.name = name;
        this.surname = surname;
        this.id = rndm.nextInt(1, 10000);
    }
    @Override
    public String toString() {
        return "Oggetto ------------------------> {" +
                "surname='" + surname + '\'' +
                ", id=" + id +
                ", name='" + name + '\'' +
                ", tipo=" + tipo +
                '}';
    }
}
