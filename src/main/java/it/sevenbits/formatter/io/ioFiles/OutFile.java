package it.sevenbits.formatter.io.ioFiles;

import it.sevenbits.formatter.io.exceptions.CloseException;
import it.sevenbits.formatter.io.exceptions.OutputException;
import it.sevenbits.formatter.io.interfaces.ICloseable;
import it.sevenbits.formatter.io.interfaces.OutputInterface;

import java.io.*;

public class OutFile implements OutputInterface, ICloseable {

    private OutputStreamWriter out;

    public OutFile(final String filename) throws OutputException {
        try {
            out = new OutputStreamWriter(new FileOutputStream( new File(filename)) , "UTF-8");
        } catch (UnsupportedEncodingException e) {
            throw new OutputException(e);
        } catch (FileNotFoundException e) {
            throw new OutputException("File not find" , e);
        }
    }

    @Override
    public void close() throws CloseException {
        try {
            out.close();
        } catch (Exception e) {
            throw new CloseException(e);
        }
    }

    @Override
    public void writeChar(final char ch) throws OutputException {
        try {
            out.write(ch);
        } catch (Exception e) {
            throw new OutputException(e);
        }

    }
}