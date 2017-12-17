package it.sevenbits.app.lexer;

/**
 * Exception for Lexer
 */
public class LexerException extends Exception {
    /**
     * @param cause - reason for exclusion
     */
    public LexerException(final Throwable cause) {
        super(cause);
    }

}
