package it.sevenbits.app;

import it.sevenbits.app.formatter.IFormatter;
import it.sevenbits.app.formatter.implementation.Formatter;
import it.sevenbits.app.io.reader.implementation.FileReader;
import it.sevenbits.app.io.writer.implementation.FileWriter;
import it.sevenbits.app.lexer.ILexer;
import it.sevenbits.app.lexer.implementation.Lexer;

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
        IFormatter formatter = new Formatter();

        try (
                FileReader reader = new FileReader(args[0]);
                FileWriter writer = new FileWriter(args[1])
        ) {
            ILexer lexer = new Lexer(reader);

            formatter.format(lexer, writer);
        }
    }
}

