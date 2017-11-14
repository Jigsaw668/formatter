package it.sevenbits.formatter.io.exceptions;

/**
 * Exclusion subclass for the output data stream
 */
public class OutputException extends Exception {
    /**
     * @param message - the detail message
     * @param cause - reason for exclusion
     */
    public OutputException(final String message, final Throwable cause) {
        super(message, cause);
    }

    /**
     * @param e - interception of an exception
     */
    public OutputException(final Exception e) {
        super(e);
    }
}
