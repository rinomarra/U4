//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Random;

public class Main {

    //private static final Logger logger = LoggerFactory.getLogger(Main.class);
    public static void main(String[] args) {

        final Logger logger = LoggerFactory.getLogger(Main.class);
        Random  rdm = new Random();
        //i numeri random di test saranno compresi fra 0 e 9
        int test = rdm.nextInt(10);
        logger.info("Numero random: "+test);
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        System.out.println("Hello and welcome!");
        int i = 1;
        for (i = 1; i <= 5; i++) {
            //TIP Press <shortcut actionId="Debug"/> to start debugging your code. We have set one <icon src="AllIcons.Debugger.Db_set_breakpoint"/> breakpoint
            // for you, but you can always add more by pressing <shortcut actionId="ToggleLineBreakpoint"/>.
            System.out.println("i = " + i);
            //i numeri di numberRdn saranno compresi fra 0 e il limite imposto dal contatore
            int numberRdn = rdm.nextInt(0, i);
            logger.debug("Valore attuale di i: "+numberRdn);
        }
        logger.info("Test informativo: "+i);
        logger.warn("Attenzione alla variabile i: "+i);
        logger.trace("Trace dell variabile ì: "+i);
    }
}