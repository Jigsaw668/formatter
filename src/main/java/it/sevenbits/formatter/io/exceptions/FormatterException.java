package it.sevenbits.formatter.io.exceptions;

/**
 * @author Denis Makarov
 */
public class FormatterException extends Exception {
    /**
     * @param cause причина
     */
    public FormatterException(final Exception cause) {
        super(cause);
    }
}
