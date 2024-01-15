package it.epicode.be.exceptions;

public class NumberLessThanZeroException extends RuntimeException {
    //Se estendo RuntimaException sto definendo una UNCHECKED Exception

    public NumberLessThanZeroException(int number) {
        super("Il numero " + number + " è minore di zero!");
    }

    public NumberLessThanZeroException() {}
}
