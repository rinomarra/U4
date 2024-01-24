package it.epicode.be.dao;

import it.epicode.be.entities.Document;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class DocumentsDao {
    private final EntityManager em;

    public DocumentsDao(EntityManager em) {
        this.em = em;
    }

    public void save(Document document) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.persist(document);
        transaction.commit();
        System.out.println("Nuovo documento salvato correttamente");
    }

    public Document findById(long id) {
        return em.find(Document.class, id);
    }

    public void findByIdAndDelete(long id) {

        Document found = em.find(Document.class, id);

        if (found != null) {

            EntityTransaction transaction = em.getTransaction();
            transaction.begin();
            em.remove(found);

            transaction.commit();
            System.out.println("Il documento è stato cancellato correttamente");
        } else {
            System.err.println("Il documento con l'id " + id + " non è stato trovato");
        }
    }
}
