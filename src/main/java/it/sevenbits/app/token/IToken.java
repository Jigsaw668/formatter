package it.sevenbits.app.token;

/**
 * Interface for token
 */
public interface IToken {
    /**
     *
     * @return Token name
     * @throws TokenException
     */
    String getName() throws TokenException;

    /**
     *
     * @return lexeme
     * @throws TokenException
     */
    String getLexeme() throws TokenException;
}
