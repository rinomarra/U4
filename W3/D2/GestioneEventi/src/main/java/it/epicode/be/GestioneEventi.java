package it.epicode.be;

import com.github.javafaker.Faker;
import it.epicode.be.dao.EventsDAO;
import it.epicode.be.entities.Event;
import it.epicode.be.entities.TipoEvento;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.time.LocalDate;
import java.util.Locale;
import java.util.Random;

public class GestioneEventi {

    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("test_unit4_w3_d2");

    public static void main(String[] args) {
        EntityManager em = emf.createEntityManager();
        Faker faker = new Faker(Locale.ITALY);
        EventsDAO eventsDAO = new EventsDAO(em);
        Random rndm = new Random();

        //2023-12-28
        for (int i = 0; i < 20; i++) {
            eventsDAO.save(new Event(
                    faker.chuckNorris().fact(),
                    LocalDate.of(rndm.nextInt(2023, 2025),
                            rndm.nextInt(1, 13),
                            rndm.nextInt(1, 29)),
                    faker.lorem().fixedString(50),
                    rndm.nextInt(1, 3) == 1 ? TipoEvento.PRIVATO : TipoEvento.PUBBLICO,
                    rndm.nextInt(1, 1000)));
        }

        Event found = eventsDAO.getById(25);
        if (found != null) {
            System.out.println(found);
        }
        else {
            System.out.println("Elemento non trovato");
        }

        eventsDAO.delete(26);
        System.out.println("Elemento con id 26 eliminato");
        em.close();
        emf.close();
    }
}
