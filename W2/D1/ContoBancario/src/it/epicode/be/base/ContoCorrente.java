package it.epicode.be.base;

import it.epicode.be.exception.BancaException;

public class ContoCorrente {
    protected String titolare;
    protected int nMovimenti;
    protected final int maxMovimenti = 50;
    protected double saldo;

    public ContoCorrente(String titolare, double saldo) {
        this.titolare = titolare;
        this.saldo = saldo;
        nMovimenti = 0;
    }

    public void preleva(double x) throws BancaException {
        if (nMovimenti < maxMovimenti)
            saldo = saldo - x;
        else
            saldo = saldo - x - 0.50;

        if (saldo < 0)
            throw new BancaException("il conto è in rosso");
        nMovimenti++;
    }

    public double restituisciSaldo() {
        return saldo;
    }
}
