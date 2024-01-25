package it.epicode.be.entities.classi_concrete;

import it.epicode.be.entities.Animal;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("Cane")
public class Dog extends Animal {

    private double maxSpeed;

    public Dog() {
    }

    public Dog(String name, int age, double maxSpeed) {
        this.name = name;
        this.age = age;
        this.maxSpeed = maxSpeed;
    }

    public double getMaxSpeed() {
        return maxSpeed;
    }

    public void setMaxSpeed(double maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    @Override
    public String toString() {
        return "Dog{" +
                "maxSpeed=" + maxSpeed +
                ", id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                "} ";
    }

}
