package it.primoprogetto.costanti;

public enum Week {
    PRIMOWEEK("Solo 3 giorni");
    //variabile privata
    private String description;
    private int numero;
    //costruttore
    Week(String s) {
    }
    //metodo per visualizzare variabili private all'esterno della mia classe
    public String getDescription() {
        return description;
    }
}
