import it.epicode.be.entities.RunUno;

public class RunnableTest {

    public static void main(String[] args) {
        //classe anonima
        /*
            Una classe anonima in Java è una classe interna senza un nome che viene dichiarata e istanziata in un'unica espressione.
            Le classi anonime sono utilizzate principalmente per creare istanze di interfacce o classi astratte
            con un solo uso, senza la necessità di dichiarare una classe concreta completa.
         */
        RunUno runTre = new RunUno();

        Runnable runUno = new Runnable() {
            @Override
            public void run() {
                System.out.println("Hello world old style!");
            }
        };
        Runnable runDue = () -> System.out.println("Hello world with Lambda!");
        //lambda function
        //Lista argomenti (e) -> Espressione
        //Lista argomenti (e) -> { Istruzioni }
        //(long a, long b) -> (a + b)
        //() -> true
        //s -> s.length()
        //(String s) -> { System.out.println("Hello world old style!" + s) };


        runUno.run();
        runDue.run();
        runTre.run();
        test();
    }

    public static void test(){
        Runnable runTest = new Runnable() {
            @Override
            public void run() {
                System.out.println("Applicazione in run");
            }
        };
    }
}
