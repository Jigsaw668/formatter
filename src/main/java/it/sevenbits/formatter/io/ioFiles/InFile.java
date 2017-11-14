package it.sevenbits.formatter.io.ioFiles;

import it.sevenbits.formatter.io.exceptions.CloseException;

import it.sevenbits.formatter.io.exceptions.InputException;
import it.sevenbits.formatter.io.interfaces.ICloseable;
import it.sevenbits.formatter.io.interfaces.InputInterface;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;

/**
 * For reading character streams
 */
public class InFile implements InputInterface, ICloseable {

    private InputStreamReader r;
    private int bt;

    /**
     * @param inputFilePath - the path to the file
     * @throws InputException - file not found
     */
    public InFile(final String inputFilePath) throws InputException {

        try {
            r = new InputStreamReader(new FileInputStream(new File(inputFilePath)) , "UTF-8");
        } catch (FileNotFoundException e) {
            throw new InputException("File not found", e);
        } catch (Exception e) {
            throw new InputException(e);
        }
    }

    @Override
    public boolean forNext() throws InputException {
        try {
            bt = r.read();
        } catch (Exception e) {
            throw new InputException("Some reading error" , e);
        }
        return (bt != -1);
    }

    @Override
    public char getChar() throws InputException {
        return (char) bt;
    }

    @Override
    public void close() throws CloseException {
        try {
            r.close();
        } catch (Exception e) {
            throw new CloseException(e);
        }
    }
}