package it.sevenbits.app.lexer;


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
     * @return true if has more token
     * @throws LexerException - NullPointerException
     */
    boolean hasMoreTokens() throws LexerException;
}
