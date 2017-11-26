package it.sevenbits.app.lexer.implementation;


import it.sevenbits.app.io.reader.IReader;
import it.sevenbits.app.io.reader.ReaderException;
import it.sevenbits.app.lexer.ILexer;
import it.sevenbits.app.token.IToken;
import it.sevenbits.app.token.implementation.Token;

/**
 * Basic implementation of ILexer
 */
public class Lexer implements ILexer {
    private IReader reader;

    /**
     * @param reader source file
     */
    public Lexer(final IReader reader) {
        this.reader = reader;
    }

    @Override
    public boolean hasMoreTokens() throws ReaderException {
        try {
            return reader.readNext();
        } catch (ReaderException e) {
            throw new ReaderException("Can't read", e);
        }
    }

    @Override
    public IToken readToken() throws ReaderException {
        try {
            String name;
            String lexeme;
            char ch = reader.getChar();
            switch (ch) {
                case ';':
                    name = "semicolon";
                    break;
                case '\r':
                    name = "newLine";
                    break;
                case '\n':
                    name = "newLine";
                    break;
                case '{':
                    name = "leftBracket";
                    break;
                case '}':
                    name = "rightBracket";
                    break;
                case ' ':
                    name = "whiteSpace";
                    break;
                default:
                    name = "otherChar";
                    break;
            }
            lexeme = Character.toString(ch);
            return new Token(name, lexeme);
        } catch (ReaderException e) {
            throw new ReaderException("Can't read for some reason", e);
        }
    }
}





