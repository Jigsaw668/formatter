package it.sevenbits.app.token;

/**
 *
 */
public class TokenException extends Exception {
    /**
     * @param message - the detail message
     * @param cause - reason for exclusion
     */
    public TokenException(final String message, final Throwable cause) {
        super(message, cause);
    }

    /**
     * @param cause - reason for exclusion
     */
    public TokenException(final Throwable cause) {
        super(cause);
    }
}
