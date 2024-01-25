package it.epicode.be;

import it.epicode.be.dao.AnimalsDAO;
import it.epicode.be.entities.classi_concrete.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Application {

    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("test_unit4_w3_d4_esercitazione");

    public static void main(String[] args) {
        System.out.println("Esercitazione W3 - D4 ");
        EntityManager em = emf.createEntityManager();
        AnimalsDAO ad = new AnimalsDAO(em);

        Cat felix = new Cat("Felix", 10, 50.5);
        Dog fido = new Dog("Fido", 10, 200);

        //ad.save(felix);
        ad.save(fido);
        // *************************************** NAMED QUERIES *********************
        ad.findByNameStartsWith("f").forEach(System.out::println);

        // *************************************** DYNAMIC QUERIES *********************
        System.out.println("---------------------- FIND ALL DOGS --------------------");
        ad.findAllDogs().forEach(System.out::println);

        ad.findAllAnimalsNames().forEach(System.out::println);

        System.out.println("---------------------- UPDATE ANIMALS --------------------");
        ad.findAnimalsByNameAndUpdateName("Fido", "Rex");

        System.out.println("---------------------- DELETE ANIMALS --------------------");
        ad.findAnimalsByNameAndDelete("Rex");

    }
}
