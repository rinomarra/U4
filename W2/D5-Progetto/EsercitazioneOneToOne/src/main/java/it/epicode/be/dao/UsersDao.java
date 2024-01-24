package it.epicode.be.dao;

import it.epicode.be.entities.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class UsersDao {
    private final EntityManager em;

    public UsersDao(EntityManager em) {
        this.em = em;
    }

    public void save(User user){
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.persist(user);
        transaction.commit();
        System.out.println("Nuovo user salvato correttamente");
    }
    public User findById(long id){
        return em.find(User.class, id);
    }

    public void findByIdAndDelete(long id){
        User found = em.find(User.class, id);
        if(found != null){
            EntityTransaction transaction = em.getTransaction();
            transaction.begin();
            em.remove(found);
            transaction.commit();
            System.out.println("Lo user è stato cancellato correttamente");
        } else {
            System.err.println("Lo user con l'id " + id + " non è stato trovato");
        }
    }
}
