package it.epicode.be;

import com.github.javafaker.Faker;
import it.epicode.be.classi_concrete.Cliente;
import it.epicode.be.classi_concrete.Fattura;
import it.epicode.be.classi_concrete.Fornitore;
import it.epicode.be.classi_concrete.Prodotto;
import it.epicode.be.enumerazioni.Tipologia;
import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;
import java.util.function.Supplier;

public class Application {

    private static final Logger logger = LoggerFactory.getLogger(Application.class);
    private static final int NUMERO_CLIENTI = 100;
    private static int idCounterClienti = 1;
    private static int idCounterFatture = 1;
    private static int idCounterProdotti = 1;
    private static int idCounterFornitore = 1;
    private static String insertCliente;
    public static void main(String[] args) throws IOException {

        System.out.println("Creare Fake dati per il db di test!");
        Faker faker = new Faker();
        File fileClienti = new File("clienti_inserts.sql");
        List<Integer> idClienti = new ArrayList<>();
        File idCounterFile = new File("idCounter.txt");
        try{
            if (idCounterFile.exists()) {
                String savedData = FileUtils.readFileToString(idCounterFile, StandardCharsets.UTF_8);
                String[] ids = savedData.split("@");

                idCounterClienti = Integer.parseInt(ids[0]);
                idCounterFatture = Integer.parseInt(ids[1]);
                idCounterProdotti = Integer.parseInt(ids[2]);
                idCounterFornitore = Integer.parseInt(ids[3]);

            }

        }catch (IOException e){
            logger.error(e.getMessage());
            throw new RuntimeException(e);
        }


        Supplier<Cliente> clienteSupplier = () -> {
            LocalDate dataNascita = faker.date().birthday().toInstant()
                    .atZone(ZoneId.systemDefault())
                    .toLocalDate();
            return new Cliente(
                    idCounterClienti++,
                    faker.name().firstName(),
                    faker.name().lastName(),
                    dataNascita,
                    faker.address().state()
            );
        };

        Supplier<Fattura> fatturaSupplier = () -> {
            int idClienteRandom = idClienti.get(new java.util.Random().nextInt(idClienti.size()));
            Tipologia tipo = Tipologia.values()[new java.util.Random().nextInt(Tipologia.values().length)];
            LocalDate dataFattura = LocalDate.now(); // Sostituito per semplicità con la data corrente
            return new Fattura(
                    idCounterFatture++,
                    tipo.name(),
                    faker.number().randomDouble(2, 100, 5000),
                    faker.number().randomDouble(2, 10, 30),
                    idClienteRandom,
                    dataFattura,
                    faker.number().randomDigitNotZero()
            );
        };

        Supplier<Prodotto> prodottoSupplier = () -> {
            // Converti le date da java.util.Date a java.time.LocalDate
            LocalDate dataAttivazione = faker.date()
                    .past(365, TimeUnit.DAYS)
                    .toInstant()
                    .atZone(ZoneId.systemDefault())
                    .toLocalDate();
            LocalDate dataDisattivazione = faker.date()
                    .future(365, TimeUnit.DAYS)
                    .toInstant()
                    .atZone(ZoneId.systemDefault())
                    .toLocalDate();

            return new Prodotto(
                    idCounterProdotti++,
                    faker.commerce().productName(),
                    faker.bool().bool(),
                    faker.bool().bool(),
                    dataAttivazione,
                    dataDisattivazione
            );
        };

        Supplier<Fornitore> fornitoreSupplier = () -> new Fornitore(
                idCounterFornitore++,
                faker.company().name(),
                faker.address().state()
        );



        for (int i = 0; i < NUMERO_CLIENTI; i++) {
            Cliente cliente = clienteSupplier.get();
            idClienti.add(cliente.getNumeroCliente());
            String insertCliente = clienteToSqlFunction.apply(cliente);
            try {
                FileUtils.writeStringToFile(fileClienti, insertCliente + System.lineSeparator(), StandardCharsets.UTF_8, true);
            } catch (IOException e) {
                logger.error(e.getMessage());
                throw new RuntimeException(e);
            }
        }
        logger.info("Creato file clienti_insert.sql");


        generateSqlFile(fatturaSupplier, "fatture_inserts.sql", fatturaToSqlFunction, 100);
        logger.info("Creato file fatture_insert.sql");
        generateSqlFile(prodottoSupplier, "prodotti_insert.sql", prodottoToSqlFunction, 100);
        logger.info("Creato file prodotti_insert.sql");
        generateSqlFile(fornitoreSupplier, "fornitori_insert.sql", fornitoreToSqlFunction, 100);
        logger.info("Creato file fornitori_insert.sql");
        logger.info("Procedura terminata");
        FileUtils.writeStringToFile(new File("idCounter.txt"), String.valueOf(idCounterClienti+"@"+idCounterFatture+"@"+idCounterProdotti+"@"+idCounterFornitore), StandardCharsets.UTF_8);


    }

    private static Function<Cliente, String>  clienteToSqlFunction = cliente -> {

        return String.format("INSERT INTO Clienti (numero_cliente, nome, cognome, data_nascita, regione_residenza) VALUES (%d, '%s', '%s', '%s', '%s');",
                cliente.getNumeroCliente(),
                cliente.getNome().replace("'", "''"), // Sostituisce apici singoli per evitare errori SQL
                cliente.getCognome().replace("'", "''"),
                cliente.getDataNascita().toString(),
                cliente.getRegioneResidenza().replace("'", "''"));
    };

    private static Function<Fattura, String> fatturaToSqlFunction = fattura -> {
        return String.format("INSERT INTO Fatture (NumeroFattura, Tipologia, Importo, Iva, IdCliente, DataFattura, NumeroFornitore) VALUES (%d, '%s', %.2f, %.2f, %d, '%s', %d);",
                fattura.getNumeroFattura(),
                fattura.getTipologia().replace("'", "''"), // Gestisce i caratteri di apice singolo
                fattura.getImporto(),
                fattura.getIva(),
                fattura.getIdCliente(),
                fattura.getDataFattura().toString(),
                fattura.getNumeroFornitore());
    };

    private static Function<Prodotto, String> prodottoToSqlFunction = prodotto -> {
        return String.format("INSERT INTO Prodotti (IdProdotto, Descrizione, InProduzione, InCommercio, DataAttivazione, DataDisattivazione) VALUES (%d, '%s', %b, %b, '%s', '%s');",
                prodotto.getIdProdotto(),
                prodotto.getDescrizione().replace("'", "''"),
                prodotto.isInProduzione(),
                prodotto.isInCommercio(),
                prodotto.getDataAttivazione().toString(),
                prodotto.getDataDisattivazione().toString());
    };

    private static Function<Fornitore, String> fornitoreToSqlFunction = fornitore -> {
        return String.format("INSERT INTO Fornitori (NumeroFornitore, Denominazione, RegioneResidenza) VALUES (%d, '%s', '%s');",
                fornitore.getNumeroFornitore(),
                fornitore.getDenominazione().replace("'", "''"), // Gestisci i caratteri di apice singolo
                fornitore.getRegioneResidenza().replace("'", "''"));
    };

    public static <T> void generateSqlFile(Supplier<T> supplier, String fileName, Function<T, String> toSqlFunction, int numberOfRecords) {
        File file = new File(fileName);
        try {
            for (int i = 0; i < numberOfRecords; i++) {
                T item = supplier.get();
                String sql = toSqlFunction.apply(item);
                FileUtils.writeStringToFile(file, sql + System.lineSeparator(), StandardCharsets.UTF_8, true);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
