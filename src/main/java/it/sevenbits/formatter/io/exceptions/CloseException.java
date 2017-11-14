package it.sevenbits.formatter.io.exceptions;

/**
 * Subclass exception to close the flow
 */
public class CloseException extends Exception {
    /**
     * @param message - the detail message
     * @param cause - reason for exclusion
     */
    public CloseException(final String message, final Throwable cause) {
        super(message, cause);
    }

    /**
     * @param e - interception of an exception
     */
    public CloseException(final Exception e) {
        super(e);
    }
}
