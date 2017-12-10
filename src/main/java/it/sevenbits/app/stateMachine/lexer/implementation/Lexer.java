package it.sevenbits.app.stateMachine.lexer.implementation;

import it.sevenbits.app.io.reader.IReader;
import it.sevenbits.app.io.reader.ReaderException;
import it.sevenbits.app.stateMachine.lexer.ILexer;
import it.sevenbits.app.stateMachine.lexer.LexerException;
import it.sevenbits.app.stateMachine.token.IToken;
import it.sevenbits.app.stateMachine.token.implementation.Token;

/**
 * reader and returns a token
 */
public class Lexer implements ILexer {

    private IReader reader;

    /**
     * Basic constructor
     * @param reader source file
     */
    public Lexer(final IReader reader) {
        this.reader = reader;
    }

    @Override
    public boolean hasMoreTokens() {
        return reader.hasMoreChars();
    }

    @Override
    public IToken readToken() throws LexerException {
        try {
            String name;
            String lexeme;
            while (reader.hasMoreChars()) {
                char ch = reader.readChar();
                switch (ch) {
                    case '{': name = "openBracket"; break;
                    case '}': name = "closeBracket"; break;
                    case ';': name = "semicolon"; break;
                    case '\n': name = "newLine"; break;
                    case ' ': name = "whitespace"; break;
                    default: name = "singleChar"; break;
                }
                lexeme = Character.toString(ch);
                return new Token(name, lexeme);
            }
        } catch (ReaderException e) {
            throw new LexerException(e);
        }
        return new Token(" ", " ");
    }
}
