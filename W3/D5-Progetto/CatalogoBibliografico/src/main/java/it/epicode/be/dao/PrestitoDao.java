package it.epicode.be.dao;

import it.epicode.be.entities.Prestito;
import it.epicode.be.entities.Utente;
import it.epicode.be.utils.JpaUtil;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

public class PrestitoDao {
    public void salva(Prestito p) {
        EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(p);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            e.printStackTrace();
            // TODO: handle exception
        } finally {
            em.close();
        }
    }

    public Prestito getById(long id) {
        EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
        try {
            em.getTransaction().begin();
            Prestito p = em.find(Prestito.class, id);
            em.getTransaction().commit();
            return p;
        } finally {
            em.close();
        }
    }

    public void delete(Prestito p) {
        EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
        try {
            em.getTransaction().begin();
            em.remove(p);
            em.getTransaction().commit();
        } catch (Exception ex) {
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
    }

    public void update(Prestito p) {
        EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
        try {
            em.getTransaction().begin();
            em.merge(p);
            em.getTransaction().commit();
        } catch (Exception ex) {
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
    }

    public List<Prestito> findAll() {
        EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
        Query q = em.createNamedQuery("Prestito.findAll");
        try {
            return q.getResultList();

        } finally {
            em.close();
        }
    }

    public List<Prestito> findByTessera(Long nTessera) {
        EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
        Query trovautente = em.createQuery("SELECT u FROM Utente u WHERE u.numeroTessara = :nTessera");
        trovautente.setParameter("nTessera", nTessera);
        try {
            Utente trovato = (Utente) trovautente.getSingleResult();
            Query q = em.createQuery("SELECT p FROM Prestito p WHERE p.utente = :utenteTrovato");
            q.setParameter("utenteTrovato", trovato);
            return q.getResultList();

        } catch (Exception e) {
            System.out.println("Presito non trovato");
            System.out.println(e);
            return null;
        } finally {
            em.close();
        }
    }

    public List<Prestito> findExpired() {
        EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
        Query q = em.createQuery("SELECT p FROM Prestito p WHERE p.dataRestituzioneEffettiva IS NULL OR p.dataRestituzionePrevista < current_date()");
        //current_date() è una funzione utilizzata in JPQL
        //è usata per ottenere la data corrente del sistema, e viene spesso impiegata in query dove è necessario fare confronti con la data odierna.
        try {
            return q.getResultList();

        } finally {
            em.close();
        }
    }
}
