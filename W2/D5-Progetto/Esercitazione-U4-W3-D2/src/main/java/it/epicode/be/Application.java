package it.epicode.be;

import it.epicode.be.dao.StudentsDAO;
import it.epicode.be.entities.Student;
import it.epicode.be.enumerazioni.StudentType;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Application {

    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("test_unit4_w3_d1");
    //"test_unit4_w3_d1" DEVE CORRISPONDERE ESATTAMENTE al nome della persistence unit dichiarata nel persistence.xml
    public static void main(String[] args) {

        System.out.println("Esercitazione W3 D2!");
        EntityManager em = emf.createEntityManager();
        // Entity Manager è responsabile della gestione delle interazioni col DB
        StudentsDAO sd = new StudentsDAO(em);

        Student aldo = new Student("Aldo", "Baglio", StudentType.BACKEND);
        Student giovanni = new Student("Giovanni", "Storti", StudentType.FULLSTACK);
        Student mario = new Student("Mario", "Rossi", StudentType.FRONTEND);

        // ************************************ SAVE ********************************
		sd.save(aldo);
		sd.save(giovanni);
		sd.save(mario);
        // ************************************ FIND BY ID ********************************
     /*   long id = 2;
        Student aldoFromDB = sd.findById(id);
        if (aldoFromDB != null) {
            System.out.println(aldoFromDB);
        } else {
            System.out.println("Studente con id " + id + " non trovato");
        }

        // ************************************ FIND BY ID AND DELETE ********************************
        sd.findByIdAndDelete(5);
*/

        // A fine programma è sempre bene ricordarsi di chiudere entitymanager e entitymanagerfactory
        em.close();
        emf.close();

    }
}
