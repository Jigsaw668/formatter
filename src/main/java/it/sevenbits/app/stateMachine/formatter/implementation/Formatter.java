package it.sevenbits.app.stateMachine.formatter.implementation;

import it.sevenbits.app.io.reader.IReader;
import it.sevenbits.app.io.writer.IWriter;
import it.sevenbits.app.io.writer.WriterException;
import it.sevenbits.app.stateMachine.formatter.FormatterException;
import it.sevenbits.app.stateMachine.formatter.IFormatter;
import it.sevenbits.app.stateMachine.lexer.ILexer;
import it.sevenbits.app.stateMachine.lexer.ILexerFactory;
import it.sevenbits.app.stateMachine.lexer.LexerException;
import it.sevenbits.app.stateMachine.token.IToken;
import it.sevenbits.app.stateMachine.token.implementation.Token;

/**
 * Class containing method for formatting code
 */
public class Formatter implements IFormatter {

    private ILexerFactory lexerFactory;

    /**
     * Basic constructor
     * @param lexerFactory lexer factory
     */
    public Formatter(final ILexerFactory lexerFactory) {
        this.lexerFactory = lexerFactory;
    }

    /**
     * Method for formatting java code
     * @param reader source file
     * @param writer output file
     * @throws FormatterException when can't format code
     */
    public void format(final IReader reader, final IWriter writer) throws FormatterException {
        ILexer lexer = lexerFactory.createLexer(reader);
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
                            write(writer, " ");
                        }
                    }
                    newLine = false;
                }
                if (newLine) {
                    continue;
                }
                if ((prevToken.getLexeme().equals(")") && !name.equals("semicolon") && !name.equals("whitespace")) ||
                        (!prevToken.getLexeme().equals("whitespace") && name.equals("openBracket"))) {
                    write(writer, " ");
                }
                prevToken = token;

                if (name.equals("semicolon") || name.equals("closeBracket") || name.equals("openBracket")) {
                    lexeme += "\n";
                    newLine = true;
                }
                write(writer, lexeme);
            }
        } catch (LexerException | WriterException e) {
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