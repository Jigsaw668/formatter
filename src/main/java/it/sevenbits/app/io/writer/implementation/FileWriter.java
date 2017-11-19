package it.sevenbits.app.io.writer.implementation;

import it.sevenbits.app.io.closeable.CloseableException;
import it.sevenbits.app.io.writer.WriterException;
import it.sevenbits.app.io.closeable.ICloseable;
import it.sevenbits.app.io.writer.IWriter;

import java.io.*;

/**
 * To write to a file character by character
 */
public class FileWriter implements IWriter, ICloseable {

    private BufferedWriter bufferedWriter;

    /**
     * @param path - in which file to write
     * @throws WriterException - file not found
     */
    public FileWriter(final String path) throws WriterException {
        try {
            FileOutputStream outputStream =
                    new FileOutputStream(new File(path));
            Writer fileWriter =
                    new OutputStreamWriter(outputStream, "utf-8");
            bufferedWriter = new BufferedWriter(fileWriter);
        } catch (Exception e) {
            throw new WriterException("Opening file error", e);
        }
    }

    @Override
    public void write(final char symbol) throws WriterException {
        try {
            bufferedWriter.write(symbol);
        } catch (Exception e) {
            throw new WriterException("Writing error", e);
        }
    }

    @Override
    public void close() throws CloseableException {
        try {
            bufferedWriter.close();
        } catch (Exception e) {
            throw new CloseableException("Closing error", e);
        }
    }
}