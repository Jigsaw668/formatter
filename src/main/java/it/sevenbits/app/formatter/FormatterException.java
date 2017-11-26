package it.sevenbits.app.formatter;

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

    /**
     *
     * @param message -
     * @param cause - reason for exclusion
     */
    public FormatterException(final String message, final Throwable cause) {
        super(message, cause);
    }

}
