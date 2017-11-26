package it.sevenbits.app.formatter.implementation;

import it.sevenbits.app.formatter.FormatterException;
import it.sevenbits.app.io.reader.IReader;
import it.sevenbits.app.io.reader.ReaderException;
import it.sevenbits.app.io.writer.WriterException;
import it.sevenbits.app.formatter.IFormatter;
import it.sevenbits.app.io.writer.IWriter;
import it.sevenbits.app.lexer.ILexer;
import it.sevenbits.app.lexer.LexerException;
import it.sevenbits.app.token.IToken;
import it.sevenbits.app.token.implementation.Token;

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

                if (name.equals("newLine") || (prevToken.getLexeme().equals(")") && name.equals("whitespace"))) {
                    continue;
                }
                if (name.equals("openBracket")) {
                    indentLevel++;
                }
                if (name.equals("closeBracket")) {
                    indentLevel--;
                }
                if (!name.equals("whitespace")) {
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
                if ((prevToken.getLexeme().equals(")") && !name.equals("semicolon") && !name.equals("whitespace")) ||
                        (!prevToken.getLexeme().equals("whitespace") && name.equals("openBracket"))) {
                    write(out, " ");
                }
                prevToken = token;

                if (name.equals("semicolon") || name.equals("closeBracket") || name.equals("openBracket")) {
                    lexeme += "\n";
                    newLine = true;
                }
                write(out, lexeme);
            }
        } catch (LexerException | WriterException e) {
            throw new FormatterException("Something went wrong", e);
        } catch (ReaderException e) {
            e.printStackTrace();
        }
    }

    private void write(final IWriter writer, final String lexeme) throws WriterException {
        char[] ch = lexeme.toCharArray();
        for (char c : ch) {
            writer.write(c);
        }
    }
}