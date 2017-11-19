package it.sevenbits.app;

import it.sevenbits.app.formatter.IFormatter;
import it.sevenbits.app.formatter.implementation.Formatter;
import it.sevenbits.app.io.reader.implementation.FileReader;
import it.sevenbits.app.io.writer.implementation.FileWriter;

/**
 * Starts reading, editing and writing to a file
 */
public class StartFormat {
    /**
     * Main method.
     * @param args console arguments
     * @throws Exception exception
     */
    public static void main(final String[] args) throws Exception {

        IFormatter formatter = new Formatter();
        try (
                FileReader in = new FileReader(args[0]);
                FileWriter out = new FileWriter(args[1])
        ) {
            formatter.format(in, out);
        }
    }
}

