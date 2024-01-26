package it.epicode.be.dao;

import it.epicode.be.entities.Concerto;
import it.epicode.be.entities.Event;
import it.epicode.be.entities.PartitaDiCalcio;
import it.epicode.be.enumerations.Genere;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import java.util.List;

public class EventsDAO {
    private EntityManager em;

    public EventsDAO(EntityManager em) {
        this.em = em;
    }


    public void save(Event evento) {
        try {
            EntityTransaction t = em.getTransaction();
            t.begin();
            em.persist(evento);
            t.commit();
            System.out.println("Evento - " + evento.getTitolo() + " - creato!");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public Event findById(long id) {
        return em.find(Event.class, id);
    }

    public void findByIdAndDelete(long id) {
        try {
            EntityTransaction t = em.getTransaction();
            Event found = em.find(Event.class, id);
            if (found != null) {
                t.begin();
                em.remove(found);
                t.commit();
                System.out.println("Evento eliminato");
            } else System.out.println("Evento non trovato");


        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public List<PartitaDiCalcio> getPartiteVinteInCasa() {
        return em.createNamedQuery("get_partite_vinte_in_casa", PartitaDiCalcio.class).getResultList();
    }

    public List<PartitaDiCalcio> getPartiteVinteInTrasferta() {
        return em.createNamedQuery("get_partite_vinte_in_trasferta", PartitaDiCalcio.class).getResultList();
    }

    public List<PartitaDiCalcio> getPartitePareggiate() {
        return em.createNamedQuery("get_partite_pareggiate", PartitaDiCalcio.class).getResultList();
    }

    public List<Concerto> getConcertiInStreaming(boolean inStreaming) {
        TypedQuery<Concerto> list =  em.createNamedQuery("get_concerti_in_streaming", Concerto.class);
        list.setParameter("inStreaming", inStreaming);
        return list.getResultList();
    }

    public List<Concerto> getConcertiPerGenere(Genere genere) {
        TypedQuery<Concerto> list = em.createQuery("SELECT c FROM Concerto c WHERE c.genere=:g", Concerto.class);
        list.setParameter("g", genere);
        return list.getResultList();
    }
}