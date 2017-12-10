package it.sevenbits.app.io.reader.implementation;

import it.sevenbits.app.io.closeable.CloseableException;

import it.sevenbits.app.io.reader.ReaderException;
import it.sevenbits.app.io.closeable.ICloseable;
import it.sevenbits.app.io.reader.IReader;

import java.io.*;

/**
 * For reading character streams
 */
public class FileReader implements IReader, ICloseable {

    private BufferedReader bufferedReader;
    private int currentSymbolId;

    /**
     * @param path - the path to the file
     * @throws ReaderException - error opening file and unsupported character set
     */
    public FileReader(final String path) throws ReaderException {

        try {
            InputStream fileStream =
                    new FileInputStream(new File(path));
            Reader fileReader =
                    new InputStreamReader(fileStream, "utf-8");
            bufferedReader = new BufferedReader(fileReader);
        } catch (FileNotFoundException e) {
            throw new ReaderException("Opening file error", e);
        } catch (Exception e) {
            throw new ReaderException("Unsupported encoding", e);
        }
    }

    @Override
    public boolean hasMoreChars() {
            return currentSymbolId >= 0;
    }

    @Override
    public char readChar() throws ReaderException {
        try {
            int prevChar = currentSymbolId;
            currentSymbolId = bufferedReader.read();
            return (char) prevChar;
        } catch (Exception e) {
            throw new ReaderException(e);
        }
    }

    @Override
    public void close() throws CloseableException {
        try {
            bufferedReader.close();
        } catch (Exception e) {
            throw new CloseableException("Closing stream error", e);
        }
    }
}