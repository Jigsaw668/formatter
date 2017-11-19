package it.sevenbits.app.io.closeable;

/**
 * Subclass exception to close the flow
 */
public class CloseableException extends Exception {
    /**
     * @param message - the detail message
     * @param cause - reason for exclusion
     */
    public CloseableException(final String message, final Throwable cause) {
        super(message, cause);
    }

    /**
     * @param cause - reason for exclusion
     */
    public CloseableException(final Throwable cause) {
        super(cause);
    }
}
