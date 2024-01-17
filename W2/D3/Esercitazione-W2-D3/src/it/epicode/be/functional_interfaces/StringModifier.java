package it.epicode.be.functional_interfaces;

@FunctionalInterface
/*
 *  Questa è un'annotazione in Java che viene utilizzata per indicare che un'interfaccia è un'interfaccia funzionale.
 *  Un'interfaccia funzionale è un'interfaccia che contiene un solo metodo astratto.
 *  L'annotazione @FunctionalInterface non è obbligatoria, ma è buona pratica usarla per due motivi:
 *
 *  Fornisce un'intenzione chiara che l'interfaccia è destinata a essere un'interfaccia funzionale.
 *  Aiuta a catturare gli errori in fase di compilazione se l'interfaccia non soddisfa i requisiti di un'interfaccia funzionale
 *  (ad esempio, se vengono aggiunti metodi astratti aggiuntivi).
 */
public interface StringModifier {
    public String modify(String str);
}

/*
*  Implementazioni
    * Implementazione tramite una classe anonima:
    *  StringModifier modifier = new StringModifier() {
    *       @Override
    *       public String modify(String str) {
    *            return str.toUpperCase();
    *       }
    *   };
    * Implementazione tramite LAMBDA FUNCTION
    * StringModifier modifier = str -> str.toUpperCase();
 */