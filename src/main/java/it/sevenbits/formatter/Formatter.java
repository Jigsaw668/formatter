package it.sevenbits.formatter;

import it.sevenbits.formatter.io.exceptions.FormatterException;
import it.sevenbits.formatter.io.exceptions.OutputException;
import it.sevenbits.formatter.io.interfaces.InFormatter;
import it.sevenbits.formatter.io.interfaces.InputInterface;
import it.sevenbits.formatter.io.interfaces.OutputInterface;


/**
 * @author Denis Makarov
 */
public class Formatter implements InFormatter {

    private static final int CONST = 10;
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

    private void writeIndent(final OutputInterface out , final int level) throws OutputException {
        for (int i = 0 ; i < level * TAB; i++) {
            out.writeChar(' ');
        }
    }

    public void format(final InputInterface in, final OutputInterface out) throws FormatterException {

        try {
            int level = 0;
            char previousChar = 0;
            char currentChar;

            while (in.forNext()) {
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

                out.writeChar(currentChar);

                if (newLine(currentChar)) {
                    out.writeChar((char) CONST);
                }
                previousChar = currentChar;

            }
        } catch (Exception e) {
            throw new FormatterException(e);
        }



    }
}
