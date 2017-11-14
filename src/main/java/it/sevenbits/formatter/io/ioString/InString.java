package it.sevenbits.formatter.io.ioString;

import it.sevenbits.formatter.io.exceptions.InputException;
import it.sevenbits.formatter.io.interfaces.InputInterface;

/**
 *  Class for working with strings
 */
public class InString implements InputInterface {
    private String sr;
    private int pos;

    /**
     *
     * @param sr - string fo reading
     */
    public InString(final String sr) {
        this.pos = -1;
        this.sr = sr;
    }

    /**
     * @return - returns true if there is a character next
     * @throws InputException - if there was a read error
     */
    public boolean forNext() throws InputException {
        if (this.pos < this.sr.length() - 1) {
            pos++;
            return true;
        }
        return false;
    }

    public char getChar() {
        return sr.charAt(pos);
    }
}
