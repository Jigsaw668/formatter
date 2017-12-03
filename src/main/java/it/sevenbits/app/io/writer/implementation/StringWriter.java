package it.sevenbits.app.io.writer.implementation;

import it.sevenbits.app.io.writer.IWriter;
import it.sevenbits.app.io.writer.WriterException;

/**
 * Writing to a string
 */
public class StringWriter implements IWriter {

    private StringBuilder resultString;

    /**
     * Constructor
     */
    public StringWriter() {
        resultString = new StringBuilder();
    }

    /**
     * @return a string
     */
    public final String toString() {
        return resultString.toString();
    }

    @Override
    public void writeChar(final char symbol) throws WriterException {
        try {
            resultString.append(symbol);
        } catch (Exception e) {
            throw new WriterException("Writing error", e);
        }
    }
}
