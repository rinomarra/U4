package it.epicode.be;

import com.github.javafaker.Faker;
import it.epicode.be.dao.AttendancesDAO;
import it.epicode.be.dao.EventsDAO;
import it.epicode.be.dao.LocationsDAO;
import it.epicode.be.dao.PeopleDAO;
import it.epicode.be.entities.Location;
import it.epicode.be.entities.PartitaDiCalcio;
import it.epicode.be.entities.Person;
import it.epicode.be.enumerations.TipoEvento;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.time.LocalDate;
import java.util.Locale;
import java.util.Random;

public class GestioneEventi {

    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("test_unit4_w3_d4_soluzione");

    public static void main(String[] args) {
        EntityManager em = emf.createEntityManager();
        Faker faker = new Faker(Locale.ITALY);
        EventsDAO eventsDAO = new EventsDAO(em);
        LocationsDAO locationsDAO = new LocationsDAO(em);
        PeopleDAO peopleDAO = new PeopleDAO(em);
        AttendancesDAO attendancesDAO = new AttendancesDAO(em);
        Random rndm = new Random();

        // ******************** SALVATAGGIO LOCATIONS, UTENTI ************************

        Location location1 = new Location(faker.address().city(), faker.address().cityName());
        locationsDAO.save(location1);

        //Location location2 = new Location(faker.address().city(), faker.address().cityName());
        //locationsDAO.save(location2);

        Person person1 = new Person(faker.name().firstName(), faker.name().lastName(), faker.internet().emailAddress(),  LocalDate.now(), rndm.nextInt(0, 2) == 0 ? 'M' : 'F');
        peopleDAO.save(person1);

        // ******************** PARTITE ************************
        PartitaDiCalcio p1 = new PartitaDiCalcio("Derby della Madonnina", LocalDate.now(), "Partitona", TipoEvento.PUBBLICO, 850000, location1, "Inter", "Milan");
        p1.setNumeroGolSquadraDiCasa(4);
        p1.setNumeroGolSquadraOspite(4);
        eventsDAO.save(p1);

        /*PartitaDiCalcio p2 = new PartitaDiCalcio("Finale Champions'League", LocalDate.now(), "Partitona", TipoEvento.PUBBLICO, 850000, location2, "Inter", "Nazionale Cantanti");
        p2.setNumeroGolSquadraDiCasa(0);
        p2.setNumeroGolSquadraOspite(18);
        p2.setSquadraVincente("Nazionale Cantanti");*/
        //eventsDAO.save(p2);

        /*PartitaDiCalcio p3 = new PartitaDiCalcio("Finale Coppa del Mondo", LocalDate.now(), "Partitona", TipoEvento.PUBBLICO, 850000, location1, "Juventus", "Brasile");
        p3.setNumeroGolSquadraDiCasa(40);
        p3.setNumeroGolSquadraOspite(4);
        p3.setSquadraVincente("Juventus");*/
        //eventsDAO.save(p3);

        System.out.println("----------------partite vinte in casa------------------");
        eventsDAO.getPartiteVinteInCasa().forEach(System.out::println);
        System.out.println("----------------partite vinte in trasferta------------------");
        eventsDAO.getPartiteVinteInTrasferta().forEach(System.out::println);
        System.out.println("----------------partite pareggiate------------------");
        eventsDAO.getPartitePareggiate().forEach(System.out::println);

        // ******************** CONCERTI ************************
        /*Location l1 = locationsDAO.findById(156);
        Location l2 = locationsDAO.findById(157);
        Concerto concerto = new Concerto("Queen Live at Wembley", LocalDate.now(), "Concertone", TipoEvento.PUBBLICO, 80000, l1, Genere.ROCK, false);
        Concerto concerto2 = new Concerto("Queen Live at Wembley - In Streaming", LocalDate.now(), "Concertone ma in streaming", TipoEvento.PUBBLICO, 1, l2, Genere.ROCK, true);
        */
        // eventsDAO.save(concerto);
        // eventsDAO.save(concerto2);

       /* System.out.println("LISTA CONCERTI STREAMING");
        eventsDAO.getConcertiInStreaming(true).forEach(System.out::println);
        System.out.println("LISTA CONCERTI ROCK");
        eventsDAO.getConcertiPerGenere(Genere.ROCK).forEach(System.out::println);*/


        em.close();
        emf.close();
    }
}
