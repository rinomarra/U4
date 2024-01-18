package it.epicode.classi_concrete;

import java.util.Objects;
import java.util.Random;

public class User implements Comparable<User> {
    private String name;
    private String surname;
    private int age;
    private int id;
    private String city;

    public User(String name, String surname, int age, String city) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        Random rndm = new Random();
        this.id = rndm.nextInt(1,100000);
        this.city = city;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public String getCity() {
        return city;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", age=" + age +
                ", id=" + id +
                ", city='" + city + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return age == user.age && id == user.id && Objects.equals(name, user.name) && Objects.equals(surname, user.surname);
    }

    @Override
    public int compareTo(User o) {
        return o.getAge() - this.getAge();
    }
}
