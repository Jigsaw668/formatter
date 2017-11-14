package it.sevenbits.formatter.io.ioStream;

import it.sevenbits.formatter.io.exceptions.CloseException;
import it.sevenbits.formatter.io.exceptions.InputException;
import it.sevenbits.formatter.io.interfaces.ICloseable;
import it.sevenbits.formatter.io.interfaces.InputInterface;

import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;

/**
 * An InputStreamReader is a bridge from byte streams to character streams:
 * It reads bytes and decodes them into characters using a specified charset
 */
public class InputStreamRead implements InputInterface, ICloseable {

    private InputStreamReader r;
    private int bt;

    /**
     * @throws InputException - invalid character set
     */
    public InputStreamRead() throws InputException {
        try {
            r = new InputStreamReader(System.in, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            throw new InputException("", e);
        }
    }

    @Override
    public boolean forNext() throws InputException {
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
    public void close() throws CloseException {

        try {
            r.close();
        } catch (Exception e) {
            throw new CloseException("Can not close System.in", e);
        }
    }
}
