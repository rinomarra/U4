package it.epicode.be.entities.classi_concrete;

import it.epicode.be.entities.Animal;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("Gatto")
public class Cat extends Animal {
    private double maxJumpHeight;

    public Cat(){}

    public Cat(String name, int age, double maxJumpHeight) {
        super(name, age);
        this.maxJumpHeight = maxJumpHeight;
    }

    public double getMaxJumpHeight() {
        return maxJumpHeight;
    }

    public void setMaxJumpHeight(double maxJumpHeight) {
        this.maxJumpHeight = maxJumpHeight;
    }

    @Override
    public String toString() {
        return "Cat{" +
                "maxJumpHeight=" + maxJumpHeight +
                ", id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
