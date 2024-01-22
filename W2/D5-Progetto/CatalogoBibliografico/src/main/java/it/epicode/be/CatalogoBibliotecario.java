package it.epicode.be;

import it.epicode.be.classi_base.ElementoLetterario;
import it.epicode.be.classi_concrete.Libro;
import it.epicode.be.classi_concrete.Rivista;
import it.epicode.be.enumerazioni.Periodicita;
import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CatalogoBibliotecario {
    private static final Logger logger = LoggerFactory.getLogger(CatalogoBibliotecario.class);

    private static final String FILE_PATH = "c:\\epicode\\catalogobibliotecario.txt";

    private Map<String, ElementoLetterario> archivio;

    public CatalogoBibliotecario() {
        this.archivio = new HashMap<String, ElementoLetterario>();
    }

    public void aggiungi(ElementoLetterario nuovoElemento) {
        archivio.put(nuovoElemento.getIsbn(), nuovoElemento);
        // Il logger supporta una notazione alternativa basata su {} per gestire i
        // parametri
        logger.info("Elemento aggiunto in archivio. ISBN: {} - Anno Pubblicazione: {}", nuovoElemento.getIsbn(),
                nuovoElemento.getAnnoPubblicazione());
    }

    public void rimuovi(String isbn) {
        ElementoLetterario elementoRimosso = archivio.remove(isbn);
        if (elementoRimosso != null)
            logger.info("Elemento rimosso dall'archivio. ISBN: {} - Anno Pubblicazione: {}", elementoRimosso.getIsbn(),
                    elementoRimosso.getAnnoPubblicazione());

    }

    public ElementoLetterario ricercaPerIsbn(String isbn) {

        return archivio.get(isbn);

    }

    public List<ElementoLetterario> ricercaPerAnnoPubblicazione(Integer annoPubblicazione) {

        return archivio.values().stream().filter(elem -> annoPubblicazione.equals(elem.getAnnoPubblicazione())) // Seleziona
                // gli
                // elementi
                // con
                // anno
                // indicato
                .collect(Collectors.toList()); // Ritorna una lista di elementi

    }

    public List<Libro> ricercaPerAutore(String autore) {

        return archivio.values().stream().filter(elem -> elem instanceof Libro) // Seleziona solo le istanze di Libro
                .map(elem -> (Libro) elem) // Effettua un cast a Libro
                .filter(elem -> autore.equals(elem.getAutore())) // Seleziona i libri con autore indicato
                .collect(Collectors.toList()); // Ritorna una lista di elementi

    }

    public void salvaCatalogo() throws IOException {

        String fileString = "";

        for (ElementoLetterario elemento : archivio.values()) {
            if (fileString.length() != 0) {
                fileString += "#";
            }
            if (elemento instanceof Libro) {
                fileString += Libro.toStringFile((Libro) elemento);
            } else if (elemento instanceof Rivista) {
                fileString += Rivista.toStringFile((Rivista) elemento);
            }
        }
        try {
            File file = new File(FILE_PATH);
            FileUtils.writeStringToFile(file, fileString, "UTF-8");
            logger.info("Dati salvati correttamente sul file " + FILE_PATH);
        } catch (IOException e) {
            logger.error("Errore durante la lettura/scrittura", e);
            throw new RuntimeException(e.getMessage());
        }
    }

    public void caricaCatalogo() throws IOException {
        this.archivio.clear();

        File file = new File(FILE_PATH);

        String fileString = FileUtils.readFileToString(file, "UTF-8");

        List<String> splitElementiString = Arrays.asList(fileString.split("#"));

        for (String curString : splitElementiString) {
            ElementoLetterario elemento = null;
            if (curString.startsWith(Libro.class.getSimpleName())) {
                elemento = Libro.fromStringFile(curString);
            } else if (curString.startsWith(Rivista.class.getSimpleName())) {
                elemento = Rivista.fromStringFile(curString);
            }
            this.archivio.put(elemento.getIsbn(), elemento);

        }
        logger.info("Dati caricati correttamente dal file " + FILE_PATH);

    }

    public static void main(String[] args) {
        CatalogoBibliotecario catalogo = new CatalogoBibliotecario();

        Libro l1 = new Libro("11111", "Guerra e Pace", 1891, 1278, "Lev Tolstoj", "Romanzo");
        Rivista r1 = new Rivista("11112", "Times", 2021, 178, Periodicita.MENSILE);

        catalogo.aggiungi(r1);
        catalogo.aggiungi(l1);

        try {
            catalogo.salvaCatalogo();

            catalogo.caricaCatalogo();

            List<Libro> ricercaPerAutore = catalogo.ricercaPerAutore("Lev Tolstoj");

            ricercaPerAutore.forEach(elem -> System.out.println("Titolo: " + elem.getTitolo()));

        } catch (IOException e) {
            logger.error("Errore durante la lettura/scrittura", e);
        }
    }
}
