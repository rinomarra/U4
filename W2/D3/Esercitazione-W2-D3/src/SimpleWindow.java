import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/*
    Swing è un toolkit grafico per l'interfaccia utente (GUI) in Java.
    È stato introdotto come parte del Java Foundation Classes (JFC) in Java 1.2.
    Swing fornisce una serie di componenti GUI come bottoni, caselle di testo, etichette, pannelli, menu, e altri elementi comuni utilizzati nelle applicazioni desktop.
 */

/*
    JavaFX è un toolkit per la creazione di applicazioni desktop moderne in Java.
    È stato introdotto per sostituire Swing come il toolkit GUI standard di Java a partire da JavaFX 2.0.
    JavaFX offre un'ampia gamma di funzionalità per la creazione di GUI ricche, incluse animazioni, effetti grafici e supporto multimediale.
 */
public class SimpleWindow extends JFrame {
    public SimpleWindow() {
        JButton button = new JButton("Click Me");
        // Aggiunta di un listener con classe anonima
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Bottone cliccato! (Classe Anonima)");
            }
        });

        this.add(button);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
        this.setVisible(true);
    }

    public static void main(String[] args) {
        new SimpleWindow();
    }
}
