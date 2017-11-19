package it.sevenbits.app.io.writer;


/**
 * Interface for working with the output stream
 */
public interface IWriter {
    /**
     * @param symbol - characters for writing
     * @throws WriterException - if an error occurs during the recording process
     */
    void write(char symbol) throws WriterException;
}
