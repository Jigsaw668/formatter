package it.sevenbits.formatter.io.exceptions;

/**
 * @author Denis Makarov
 */
public class InputException extends Exception {
    /**
     * @param message сообщение деталей
     * @param cause причина
     */
    public InputException(final String message, final Throwable cause) {
        super(message, cause);
    }

    public InputException(final Exception e) {
        super(e);
    }
}
