package it.sevenbits.app.stateMachine.lexer;

import it.sevenbits.app.stateMachine.token.IToken;

/**
 * Interface for lexer
 */
public interface ILexer {

    /**
     * Checks if there's tokens left to read
     * @return true if there's tokens left to read
     */
    boolean hasMoreTokens();

    /**
     * Read token
     * @return token
     * @throws LexerException when can't read
     */
    IToken readToken() throws LexerException;
}
