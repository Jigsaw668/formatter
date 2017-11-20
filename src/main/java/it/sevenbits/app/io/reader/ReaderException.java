package it.sevenbits.app.io.reader;

/**
 * Exclusion subclass for the input data stream
 */
public class ReaderException extends Exception {
    /**
     * @param message - the detail message
     * @param cause - reason for exclusion
     */
    public ReaderException(final String message, final Throwable cause) {
        super(message, cause);
    }

    /**
     * @param cause - reason for exclusion
     */
    public ReaderException(final Throwable cause) {
        super(cause);
    }
}
