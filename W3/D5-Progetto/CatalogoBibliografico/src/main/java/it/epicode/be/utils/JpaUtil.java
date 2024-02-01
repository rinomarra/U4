package it.epicode.be.utils;

import lombok.Getter;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JpaUtil {
    @Getter
    private static final EntityManagerFactory entityManagerFactory;
    /*Static Block:
    Il blocco statico, indicato dalla parola chiave static, è un blocco di codice che viene eseguito quando la classe viene caricata
    in memoria per la prima volta. Questo blocco viene eseguito prima di qualsiasi costruttore o blocchi
    di inizializzazione non statici quando si crea un'istanza della classe.
    Poiché EntityManagerFactory è solitamente un oggetto costoso da creare e può essere riutilizzato, ha senso inizializzarlo una sola volta
    a livello di classe, anziché creare nuove istanze ogni volta che è necessario.
     */
    static {
        try {
            entityManagerFactory = Persistence.createEntityManagerFactory("BEUnit1Week3Lecture5ProgettoSettimanale");
        } catch (Throwable ex) {
            System.err.println("Inizializzazione della creazione dell'EntityManagerFactory è fallita. " + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }
}
