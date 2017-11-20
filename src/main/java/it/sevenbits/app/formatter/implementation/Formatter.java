package it.sevenbits.app.formatter.implementation;

import it.sevenbits.app.formatter.FormatterException;
import it.sevenbits.app.io.reader.IReader;
import it.sevenbits.app.io.writer.WriterException;
import it.sevenbits.app.formatter.IFormatter;
import it.sevenbits.app.io.writer.IWriter;

/**
 * Edit and write to the output stream
 */
public class Formatter implements IFormatter {

    private static final int NEWLINE = 10;
    private static final int TAB = 4;

    private boolean skip(final char ch) {
        return "\n\t".indexOf(ch) != -1;
    }

    private boolean newLine(final char ch) {
        return "{};".indexOf(ch) != -1;
    }

    private boolean gradeUp(final char ch) {
        return ch == '{';
    }

    private boolean gradeDown(final char ch) {
        return ch == '}';
    }

    private void writeIndent(final IWriter out , final int level) throws WriterException {
        for (int i = 0 ; i < level * TAB; i++) {
            out.write(' ');
        }
    }
    /**
     * @param reader - input
     * @param writer - output
     * @throws FormatterException - read or write exceptions
     */
    public void format(final IReader reader, final IWriter writer) throws FormatterException {

        try {
            int level = 0;
            char previousChar = 0;
            char currentChar;

            while (reader.readChar()) {
                currentChar = reader.hasMoreChars();

                if (skip(currentChar)) {
                    continue;
                }

                if (gradeDown(currentChar)) {
                    level--;
                }

                if (newLine(previousChar)) {
                    writeIndent(writer, level);
                }

                if (gradeUp(currentChar)) {
                    level++;
                }

                writer.write(currentChar);

                if (newLine(currentChar)) {
                    writer.write((char) NEWLINE);
                }
                previousChar = currentChar;
            }
        } catch (Throwable e) {
            throw new FormatterException(e);
        }
    }
}