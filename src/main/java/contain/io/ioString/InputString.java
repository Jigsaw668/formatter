package contain.io.ioString;

import contain.exceptions.InputException;
import contain.interfaces.InputInterface;

/**
 * @author Denis Makarov
 */
public class InputString implements InputInterface {

    public InputString(final String st) {
        this.pos = -1;
        this.st = st;
    }

    private String st;
    private int pos;

    public boolean readNext() throws InputException {
        if (this.pos < this.st.length() - 1) {
            pos++;
            return true;
        }
        return false;
    }

    public char getChar() {
        return st.charAt(pos);
    }
}
