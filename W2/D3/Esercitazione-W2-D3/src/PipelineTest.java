import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class PipelineTest {
    public static void main(String[] args) {
        List<String> words = Arrays.asList("Apple", "Banana", "Cherry", "Date");

        List<String> result = words.stream()     // Sorgente
                .filter(s -> s.startsWith("B"))  // Operazione intermedia
                //In Java, l'operatore :: è noto come "riferimento a metodo" (method reference).
                //Double colon (::) operator
                .map(String::toUpperCase)        // Operazione intermedia
                .collect(Collectors.toList());   // Operazione terminale

        System.out.println(result); // Stampa [BANANA]
    }
}
