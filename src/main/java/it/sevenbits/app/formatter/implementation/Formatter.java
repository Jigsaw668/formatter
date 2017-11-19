package it.sevenbits.app.formatter.implementation;

import it.sevenbits.app.formatter.FormatterException;
import it.sevenbits.app.io.writer.WriterException;
import it.sevenbits.app.formatter.IFormatter;
import it.sevenbits.app.io.reader.IReader;
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
     * @param in - input
     * @param out - output
     * @throws FormatterException - read or write exceptions
     */
    public void format(final IReader in, final IWriter out) throws FormatterException {

        try {
            int level = 0;
            char previousChar = 0;
            char currentChar;

            while (in.readNext()) {
                currentChar = in.getChar();

                if (skip(currentChar)) {
                    continue;
                }

                if (gradeDown(currentChar)) {
                    level--;
                }

                if (newLine(previousChar)) {
                    writeIndent(out , level);
                }

                if (gradeUp(currentChar)) {
                    level++;
                }

                out.write(currentChar);

                if (newLine(currentChar)) {
                    out.write((char) NEWLINE);
                }
                previousChar = currentChar;
            }
        } catch (Throwable e) {
            throw new FormatterException(e);
        }
    }
}
