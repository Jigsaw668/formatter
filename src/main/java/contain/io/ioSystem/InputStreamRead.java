package contain.io.ioSystem;

import contain.exceptions.InputException;
import contain.interfaces.ICloseable;
import contain.interfaces.InputInterface;

import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;

/**
 * @author Denis Makarov
 */
public class InputStreamRead implements InputInterface, ICloseable {

    private InputStreamReader r;
    private int bt;

    public InputStreamRead() throws InputException {

        try {
            r = new InputStreamReader(System.in, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            throw new InputException(e);
        }
    }

    @Override
    public boolean readNext() throws InputException {

        try {
            bt = r.read();
        } catch (Exception e) {
            throw new InputException("Some reading error", e);
        }
        return (bt != -1);
    }

    @Override
    public char getChar() {
        return (char) bt;
    }

    @Override
    public void close() throws InputException {

        try {
            r.close();
        } catch (Exception e) {
            throw new InputException("Can not close System.in", e);
        }
    }
}
