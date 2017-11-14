package it.sevenbits.formatter.io.exceptions;

/**
 * Exception subclass for the format method
 */
public class FormatterException extends Exception {
    /**
     * @param cause - reason for exclusion
     */
    public FormatterException(final Throwable cause) {
        super(cause);
    }
}
