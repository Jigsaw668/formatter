package it.sevenbits.app.io.reader.implementation;

import it.sevenbits.app.io.reader.ReaderException;
import it.sevenbits.app.io.reader.IReader;

/**
 *  Class for working with strings
 */
public class StringReader implements IReader {

    private String value;
    private int index;

    /**
     *
     * @param value - string fo reading
     */
    public StringReader(final String value) {

        this.value = value;
    }

    /**
     * @return - returns true if there is a character next
     * @throws ReaderException - if there was a read error
     */
    public boolean readChar() throws ReaderException {
        return index < value.length();
    }

    /**
     *
     * @return - returns a character from the array of the string at the specified index
     * @throws ReaderException - reading outside the line
     */
    public char hasMoreChars() throws ReaderException {

        try {
            return value.charAt(index++);
        } catch (StringIndexOutOfBoundsException e) {
            throw new ReaderException("Attempting to read outside of the string", e);
        }
    }
}
