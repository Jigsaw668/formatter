package it.sevenbits.app.lexer.token;

/**
 * Interface for token
 */
public interface IToken {
    /**
     * @return Token name
     */
    String getName();

    /**
     * @return lexeme
     */
    String getLexeme();
}
