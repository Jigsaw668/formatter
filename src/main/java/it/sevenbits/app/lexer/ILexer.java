package it.sevenbits.app.lexer;

import it.sevenbits.app.io.reader.IReader;
import it.sevenbits.app.io.reader.ReaderException;
import it.sevenbits.app.token.IToken;

/**
 * Interface for Lexer
 */
public interface ILexer {
    /**
     *
     * @return token
     * @throws LexerException - NullPointerException
     */
    IToken readToken() throws LexerException;

    /**
     * @param reader -IReader
     * @return true if has more token
     * @throws LexerException - NullPointerException
     */
    boolean hasMoreTokens(IReader reader) throws LexerException;
}
