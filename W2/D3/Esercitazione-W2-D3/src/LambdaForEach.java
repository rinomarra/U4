import java.util.HashMap;
import java.util.Map;

public class LambdaForEach {
    public static void main(String[] args) {
        // Creazione della prima HashMap
        Map<String, Integer> mapUno = new HashMap<>();
        Map<String, Integer> map = new HashMap<>();
        map.put("Uno", 1);
        map.put("Due", 2);
        map.put("Tre", 3);

        // Stampa della mappa originale
        System.out.println("Mappa Originale:");
        map.forEach((key, value) -> System.out.println("Chiave: " + key + ", Valore: " + value));

        // Utilizzo di replaceAll per modificare i valori
        map.replaceAll((key, value) -> value * 2);
        //map.replaceAll((pippo, pluto) -> pluto * 2);

        // Stampa della mappa modificata
        System.out.println("\nMappa Dopo replaceAll:");
        map.forEach((key, value) -> System.out.println("Chiave: " + key + ", Valore: " + value));

        // Creazione della seconda HashMap per il confronto
        Map<String, Integer> anotherMap = new HashMap<>();
        anotherMap.put("Uno", 2);
        anotherMap.put("Due", 4);
        anotherMap.put("Tre", 6);

        // Confronto delle due mappe
        System.out.println("\nLe due mappe sono uguali? " + map.equals(anotherMap));
    }
}
