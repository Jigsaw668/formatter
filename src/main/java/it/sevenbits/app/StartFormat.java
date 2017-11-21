package it.sevenbits.app;

import it.sevenbits.app.formatter.IFormatter;
import it.sevenbits.app.formatter.implementation.Formatter;
import it.sevenbits.app.io.reader.implementation.FileReader;
import it.sevenbits.app.io.writer.implementation.FileWriter;

/**
 * Starts reading, editing and writing to a file
 */
public final class StartFormat {
    private StartFormat() {}
    /**
     * Main method.
     * @param args console arguments
     * @throws Exception exception
     */
    public static void main(final String[] args) throws Exception {

        try (
                FileReader reader = new FileReader(args[0]);
                FileWriter writer = new FileWriter(args[1])
        ) {
            IFormatter formatter = new Formatter();

            formatter.format(reader, writer);
        }
    }
}

