package it.epicode.be.dao;

import it.epicode.be.entities.Utente;
import it.epicode.be.utils.JpaUtil;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

public class UtenteDao {
    public void salva(Utente utente) {
        EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(utente);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            e.printStackTrace();
        } finally {
            em.close();
        }
    }
    public Utente   getById(long id) {
        EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
        try {
            em.getTransaction().begin();
            Utente u = em.find(Utente.class, id);
            em.getTransaction().commit();
            return u;
        } finally {
            em.close();
        }
    }
    public void delete(Utente utente) {
        EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
        try {
            em.getTransaction().begin();
            em.remove(utente);
            em.getTransaction().commit();
        } catch (Exception ex) {
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
    }
    public void update(Utente utente) {
        EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
        try {
            em.getTransaction().begin();
            em.merge(utente);
            em.getTransaction().commit();
        } catch (Exception ex) {
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
    }
    public List<Utente> findAll(){
        EntityManager em= JpaUtil.getEntityManagerFactory().createEntityManager();
        Query q = em.createNamedQuery("utenteFindAll");
        try {
            return q.getResultList();

        } finally {
            em.close();
        }
    }
}
