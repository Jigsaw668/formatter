package it.sevenbits.app.oldFormatter.lexer.implementation;


import it.sevenbits.app.io.reader.IReader;
import it.sevenbits.app.io.reader.ReaderException;
import it.sevenbits.app.oldFormatter.lexer.ILexer;
import it.sevenbits.app.oldFormatter.lexer.LexerException;
import it.sevenbits.app.stateMachine.token.IToken;
import it.sevenbits.app.stateMachine.token.implementation.Token;

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
    public boolean hasMoreTokens() throws LexerException {
        try {
            return reader.hasMoreChars();
        } catch (ReaderException e) {
            throw new LexerException("Can't read", e);
        }
    }

    @Override
    public IToken readToken() throws LexerException {
        try {
            String name;
            String lexeme;
            char ch = reader.readChar();
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
            throw new LexerException("Can't read for some reason", e);
        }
    }
}





