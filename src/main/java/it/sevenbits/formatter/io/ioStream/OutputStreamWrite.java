package it.sevenbits.formatter.io.ioStream;

import it.sevenbits.formatter.io.exceptions.CloseException;
import it.sevenbits.formatter.io.exceptions.OutputException;
import it.sevenbits.formatter.io.interfaces.ICloseable;
import it.sevenbits.formatter.io.interfaces.OutputInterface;

import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.io.Writer;

/**
 * @author Denis Makarov
 */
public class OutputStreamWrite implements OutputInterface, ICloseable {

    private OutputStreamWriter out;

    public OutputStreamWrite() throws OutputException {
        try {
            out = new OutputStreamWriter(System.out, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            throw new OutputException("Incorrect ch", e);
        }
    }

    public void setStream(final Writer stream) {
    }

    @Override
    public void writeChar(final char ch) throws OutputException {
        try {
            out.write(ch);
        } catch (Exception e) {
            throw new OutputException("Some error with write char", e);
        }
    }

    @Override
    public void close() throws CloseException {
        try {
            out.close();
        } catch (Exception e) {
            throw new CloseException("Can not close System.in", e);
        }
    }
}
