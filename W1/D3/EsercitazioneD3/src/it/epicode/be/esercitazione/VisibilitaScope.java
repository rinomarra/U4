package it.epicode.be.esercitazione;

public class VisibilitaScope {
    //Scope d'istanza
    private String attributo;
    private void metodoSemplice(){
        //variabile con scope nel blocco di codice del metodo
        int numero = 5;
        for (int i = 0; i < 10; i++) {
            //Scope di blocco
            int y = i;
            y = numero;
            String test = attributo;
        }
    }
}
