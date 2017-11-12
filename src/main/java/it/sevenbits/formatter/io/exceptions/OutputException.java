package it.sevenbits.formatter.io.exceptions;

import java.io.UnsupportedEncodingException; /**
 * @author Denis Makarov
 */
public class OutputException extends Exception {
    /**
     * @param message сообщение деталей
     * @param cause причина
     */
    public OutputException(final String message, final Throwable cause) {
        super(message, cause);
    }

    public OutputException(final Exception e) {
        super(e);
    }
}
