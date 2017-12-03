package it.sevenbits.app.oldFormatter.formatter.implementation;

import it.sevenbits.app.oldFormatter.formatter.FormatterException;

import it.sevenbits.app.io.writer.WriterException;
import it.sevenbits.app.oldFormatter.formatter.IFormatter;
import it.sevenbits.app.io.writer.IWriter;
import it.sevenbits.app.oldFormatter.lexer.ILexer;
import it.sevenbits.app.stateMachine.token.IToken;
import it.sevenbits.app.stateMachine.token.implementation.Token;

/**
 * Edit and write to the output stream
 */
public class Formatter implements IFormatter {

    /**
     * Basic constructor
     */
    public Formatter() {

    }

    /**
     * * Method for formatting java code
     * @param lexer lexer
     * @param out output file
     * @throws FormatterException when can't format code
     */
    public void format(final ILexer lexer, final IWriter out) throws FormatterException {
        try {
            final int indent = 4;

            IToken prevToken = new Token(" ", " ");
            boolean newLine = false;
            int indentLevel = 0;

            while (lexer.hasMoreTokens()) {
                IToken token = lexer.readToken();
                String name = token.getName();
                String lexeme = token.getLexeme();

                if (name.equals("newLine") || (prevToken.getLexeme().equals(")") && name.equals("whiteSpace"))) {
                    continue;
                }
                if (name.equals("leftBracket")) {
                    indentLevel++;
                }
                if (name.equals("rightBracket")) {
                    indentLevel--;
                }
                if (!name.equals("whiteSpace")) {
                    if (newLine) {
                        for (int i = 0; i < indentLevel * indent; i++) {
                            write(out, " ");
                        }
                    }
                    newLine = false;
                }
                if (newLine) {
                    continue;
                }
                if ((prevToken.getLexeme().equals(")") && !name.equals("semicolon") && !name.equals("whiteSpace")) ||
                        (!prevToken.getLexeme().equals("whiteSpace") && name.equals("leftBracket"))) {
                    write(out, " ");
                }
                prevToken = token;

                if (name.equals("semicolon") || name.equals("rightBracket") || name.equals("leftBracket")) {
                    lexeme += "\n";
                    newLine = true;
                }
                write(out, lexeme);
            }
        } catch (Exception e) {
            throw new FormatterException("Something went wrong", e);
        }
    }

    private void write(final IWriter writer, final String lexeme) throws WriterException {
        char[] ch = lexeme.toCharArray();
        for (char c : ch) {
            writer.writeChar(c);
        }
    }
}