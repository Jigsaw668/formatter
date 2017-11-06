package contain.io.ioString;

import contain.exceptions.OutputException;
import contain.interfaces.OutputInterface;

/**
 * @author Denis Makarov
 */
public class OutputString implements OutputInterface {

    public String getSt() {
        return st;
    }

    private String st = "";
    public void writeChar(final char ch) throws OutputException {
        st += ch;
    }
}
