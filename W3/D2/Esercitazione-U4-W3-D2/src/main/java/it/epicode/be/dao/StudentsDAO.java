package it.epicode.be.dao;

import it.epicode.be.entities.Student;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class StudentsDAO {
    // DAO (Data Access Object) è un Design Pattern. Serve per nascondere i dettagli implementativi
    // dei metodi che accederanno al database, i quali possono esser anche abbastanza complessi.
    // Nascondendoli forniamo al main e a chi ne avrà bisogno una classe con dei comodi metodi, con dei
    // nomi parlanti, che andranno ad interagire col DB fornendo tutte le operazioni necessarie.
    private final EntityManager em; // Tutti i metodi qua sotto avranno bisogno dell'EntityManager poichè dovranno interagire col DB

    public StudentsDAO(EntityManager em){
        this.em = em;
    }

    public void save(Student student){
        // 0. Ho bisogno di una transazione (mi viene fornita dall'EntityManager)
        EntityTransaction transaction = em.getTransaction();
        // 1. Inizio la transazione
        transaction.begin();
        // 2. Aggiungo lo studente al Persistence Context (ma non è ancora salvato a DB in questo momento)
        em.persist(student);
        // 3. Concludo la transazione col salvataggio effettivo di una nuova riga nella tabella students
        transaction.commit();
        System.out.println("Studente " + student.getName() + " aggiunto correttamente!");
    }

    public Student findById(long id){
        //SELECT * FROM students WHERE id = 1
        return em.find(Student.class, id);
    }

    public void findByIdAndDelete(long id){

        Student found = this.findById(id);

        if(found != null){
            // 2. Se lo studente c'è lo elimino
            // 2.0 Ho bisogno di una transazione (mi viene fornita dall'EntityManager
            EntityTransaction transaction = em.getTransaction();
            // 2.1 Inizio la transazione
            transaction.begin();
            // 2.2 Rimuovo l'oggetto dal Persistence Context (in questo momento non sarà ancora rimosso da DB)
            em.remove(found);
            // 2.3. Concludo la transazione con la rimozione effettiva di una riga dalla tabella students
            transaction.commit();
            System.out.println("Studente " + found.getName() + " eliminato correttamente!");

        } else {
            // 3. Se non c'è --> "Non trovato"
            System.out.println("Lo studente con l'id " + id + " non è stato trovato");
        }

    }

}
