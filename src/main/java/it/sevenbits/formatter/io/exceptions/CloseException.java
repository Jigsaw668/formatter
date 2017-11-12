package it.sevenbits.formatter.io.exceptions;

/**
 * @author Makarov Denis
 */
public class CloseException extends Exception {
    /**
     * @param message сообщение деталей
     * @param cause причина
     */
    public CloseException(final String message, final Throwable cause) {
        super(message, cause);
    }

    public CloseException(final Exception e) {
        super(e);
    }
}
