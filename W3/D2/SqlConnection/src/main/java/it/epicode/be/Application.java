package it.epicode.be;

import java.sql.*;

public class Application {

    public static void main(String[] args) {
        // Nota: PostgreSQL utilizza il prefisso "jdbc:postgresql://" per l'URL di connessione
        String url = "jdbc:postgresql://localhost:5432/test_unit4_w3_d1";
        String username = "postgres";
        String password = "epicode2023";

        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            System.out.println("Database connected!");

            // Esempio di operazione: selezionare tutti i clienti
            String query = "SELECT * FROM gestionale.clienti";

            try (PreparedStatement stmt = connection.prepareStatement(query)) {
                ResultSet rs = stmt.executeQuery();

                while (rs.next()) {
                    int numeroCliente = rs.getInt("numerocliente");
                    String nome = rs.getString("nome");
                    String cognome = rs.getString("cognome");

                    System.out.println("Cliente #" + numeroCliente + ": " + nome + " " + cognome);

                }
            } catch (SQLException e) {
                System.out.println("Error while querying the database: " + e.getMessage());
            }

        } catch (SQLException e) {
            throw new IllegalStateException("Cannot connect the database!", e);
        }
    }
}
