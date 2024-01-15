package it.epicode.be.concrete;

import it.epicode.be.base.ContoCorrente;
import it.epicode.be.exception.BancaException;

public class ContoOnLine extends ContoCorrente {
    double maxPrelievo;

    public ContoOnLine(String titolare, double saldo, double maxP) {
        super(titolare, saldo);
        this.maxPrelievo = maxP;
    }

    public void stampaSaldo() {

        System.out.println("Titolare: " + titolare + " - Saldo: " + saldo + " - Num movimenti: " + nMovimenti
                + " - Massimo movimenti: " + maxMovimenti + " - Massimo prelievo possibile: " + maxPrelievo);
    }

    public void preleva(double x) throws BancaException {
        if (x <= maxPrelievo) {
            super.preleva(x);
        }
        if (x > maxPrelievo)
            throw new BancaException("Il prelievo non è disponibile");
    }
}

