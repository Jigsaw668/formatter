package it.sevenbits.formatter.io.ioString;

import it.sevenbits.formatter.io.interfaces.OutputInterface;

/**
 * @author Denis Makarov
 */
public class OutString implements OutputInterface {

    private StringBuilder st;

    public OutString() {
        st = new StringBuilder();
    }

    public String getString() {
        return st.toString();
    }

    public void writeChar(final char ch) {
        st.append(ch);
    }
}
