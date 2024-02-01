package it.epicode.be.dao;

import it.epicode.be.log.ApplicationLog;
import it.epicode.be.utils.JpaUtil;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

public class ApplicationLogDao {
    public void salva(ApplicationLog a) {
        EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(a);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            e.printStackTrace();
        } finally {
            em.close();
        }
    }
    public ApplicationLog getByISBM(long id) {
        EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
        try {
            em.getTransaction().begin();
            ApplicationLog a = em.find(ApplicationLog.class, id);
            em.getTransaction().commit();
            return a;
        } finally {
            em.close();
        }
    }
    public void delete(ApplicationLog a) {
        EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
        try {
            em.getTransaction().begin();
            em.remove(a);
            em.getTransaction().commit();
        } catch (Exception ex) {
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
    }
    public void update(ApplicationLog a) {
        EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
        try {
            em.getTransaction().begin();
            em.merge(a);
            em.getTransaction().commit();
        } catch (Exception ex) {
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
    }
    public List<ApplicationLog> findAll(){
        EntityManager em= JpaUtil.getEntityManagerFactory().createEntityManager();
        Query q = em.createNamedQuery("elementoCatalogoFindAll");
        try {
            return q.getResultList();
        } finally {
            em.close();
        }
    }
}
