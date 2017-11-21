package it.sevenbits.app.io.reader;

/**
 * Interface for working with input stream
 */
public interface IReader {
    /**
     * @return - returns true if there is a character next
     * @throws ReaderException - if there was a read error
     */
    boolean readNext() throws ReaderException;

    /**
     * @return - returns the value of the specified field as a char
     * @throws ReaderException - the specified cast is inadmissible
     */
    char getChar() throws ReaderException;
}
