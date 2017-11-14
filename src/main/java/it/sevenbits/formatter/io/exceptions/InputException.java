package it.sevenbits.formatter.io.exceptions;

/**
 * Exclusion subclass for the input data stream
 */
public class InputException extends Exception {
    /**
     * @param message - the detail message
     * @param cause - reason for exclusion
     */
    public InputException(final String message, final Throwable cause) {
        super(message, cause);
    }

    /**
     * @param e - interception of an exception
     */
    public InputException(final Exception e) {
        super(e);
    }
}
