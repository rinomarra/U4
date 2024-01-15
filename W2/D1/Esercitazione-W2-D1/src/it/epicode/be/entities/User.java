package it.epicode.be.entities;

import it.epicode.be.exceptions.InvalidStringException;
import it.epicode.be.exceptions.NumberLessThanZeroException;

public class User {
    //variabili
    private String name;
    private String surname;
    private int age;

    //costruttore
    public User(String name, String surname, int age) {
        this.name = name;
        this.surname = surname;
        this.age = age;
    }
    //eventuali metodi
    //getters
    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public int getAge() {
        return age;
    }

    //setters
    public void setName(String name) throws InvalidStringException {
        if(name.length() <=2) throw new InvalidStringException(name + " è troppo corto. Minimo 3 caratteri!");
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setAge(int age) {
        if(age < 0) throw new NumberLessThanZeroException(age);
        this.age = age;
    }
}
