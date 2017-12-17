package it.sevenbits.app.formatter;

/**
 * Exception subclass for the format method
 */
public class FormatterException extends Exception {
    /**
     *
     * @param message -
     * @param cause - reason for exclusion
     */
    public FormatterException(final String message, final Throwable cause) {
        super(message, cause);
    }

    /**
     *
     * @param e - message
     */
    public FormatterException(final Exception e) {
    }
}
