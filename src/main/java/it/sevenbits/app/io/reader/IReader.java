package it.sevenbits.app.io.reader;

/**
 * Interface for working with input stream
 */
public interface IReader {
    /**
     * @return - returns true if there is a character next
     */
    boolean hasMoreChars() throws ReaderException;

    /**
     * @return - returns the value of the specified field as a char
     * @throws ReaderException - the specified cast is inadmissible
     */
    char readChar() throws ReaderException;
}
