package it.sevenbits.app.lexer;

/**
 * Exception for Lexer
 */
public class LexerException extends Exception {
    /**
     * @param message - the detail message
     * @param cause - reason for exclusion
     */
    public LexerException(final String message, final Throwable cause) {
        super(message, cause);
    }

    /**
     * @param cause - reason for exclusion
     */
    public LexerException(final Throwable cause) {
        super(cause);
    }

}
