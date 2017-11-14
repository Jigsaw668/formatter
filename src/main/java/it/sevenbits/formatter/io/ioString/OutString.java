package it.sevenbits.formatter.io.ioString;

import it.sevenbits.formatter.io.interfaces.OutputInterface;

/**
 * Writing to a string
 */
public class OutString implements OutputInterface {

    private StringBuilder sr;

    /**
     * Constructor
     */
    public OutString() {
        sr = new StringBuilder();
    }

    public String getString() {
        return sr.toString();
    }

    /**
     * @param ch - characters for writing
     */
    public void writeChar(final char ch) {
        sr.append(ch);
    }
}
