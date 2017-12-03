package it.sevenbits.app.io.writer;


/**
 * Interface for working with the output stream
 */
public interface IWriter {
    /**
     * @param c - characters for writing
     * @throws WriterException - if an error occurs during the recording process
     */
    void writeChar(char c) throws WriterException;
}
