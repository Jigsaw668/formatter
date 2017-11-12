package it.sevenbits.formatter.io.interfaces;


import it.sevenbits.formatter.io.exceptions.OutputException;

/**
 * @author Denis Makarov
 */
public interface OutputInterface {
    void writeChar(char ch) throws OutputException;
}
