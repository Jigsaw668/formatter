package contain.Io;

import contain.interfaces.Input;

import java.io.*;


public class InputStreamRead implements Input {
    private InputStreamReader reader;
    private int bt;


    public InputStreamRead() {
        reader = new InputStreamReader(System.in);
    }

    public boolean readNext() throws IOException {
        bt = reader.read();
        return (bt != -1);
    }

    public char getChar() {
        return (char) bt;
    }

    public void close() throws IOException {
        reader.close();
    }


}
