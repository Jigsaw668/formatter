package it.sevenbits.app.oldFormatter.lexer;


import it.sevenbits.app.io.reader.ReaderException;
import it.sevenbits.app.stateMachine.token.IToken;

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
