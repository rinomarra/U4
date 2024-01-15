package it.epicode.be.exceptions;

public class InvalidStringException extends Exception{
    //se estendo Exception stiamo definendo una CHECKED Exception
    public InvalidStringException(String message) {
        super(message);
    }
}
