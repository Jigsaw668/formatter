package it.sevenbits.formatter.io.interfaces;

import it.sevenbits.formatter.io.exceptions.InputException;

/**
 * Interface for working with input stream
 */
public interface InputInterface {
    /**
     * @return - returns true if there is a character next
     * @throws InputException - if there was a read error
     */
    boolean forNext() throws InputException;

    /**
     * @return - returns the value of the specified field as a char
     * @throws InputException - the specified cast is inadmissible
     */
    char getChar() throws InputException;
}
