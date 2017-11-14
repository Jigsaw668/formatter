package it.sevenbits.formatter.io.interfaces;


import it.sevenbits.formatter.io.exceptions.OutputException;

/**
 * Interface for working with the output stream
 */
public interface OutputInterface {
    /**
     * @param ch - characters for writing
     * @throws OutputException - if an error occurs during the recording process
     */
    void writeChar(char ch) throws OutputException;
}
