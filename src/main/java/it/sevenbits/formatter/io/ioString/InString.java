package it.sevenbits.formatter.io.ioString;

import it.sevenbits.formatter.io.exceptions.InputException;
import it.sevenbits.formatter.io.interfaces.InputInterface;

/**
 * @author Denis Makarov
 */
public class InString implements InputInterface {

    public InString(final String st) {
        this.pos = -1;
        this.st = st;
    }

    private String st;
    private int pos;

    public boolean forNext() throws InputException {
        if (this.pos < this.st.length() - 1) {
            pos++;
            return true;
        }
        return false;
    }

    public char getChar() {
        return st.charAt(pos);
    }

    public void reset() {
        pos = -1;
    }
}
