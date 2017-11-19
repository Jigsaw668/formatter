package it.sevenbits.app.io.writer;

/**
 * Exclusion subclass for the output data stream
 */
public class WriterException extends Exception {
    /**
     * @param message - the detail message
     * @param cause - reason for exclusion
     */
    public WriterException(final String message, final Throwable cause) {
        super(message, cause);
    }

    /**
     * @param cause - reason for exclusion
     */
    public WriterException(final Throwable cause) {
        super(cause);
    }
}
