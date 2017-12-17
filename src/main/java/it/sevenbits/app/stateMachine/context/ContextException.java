package it.sevenbits.app.stateMachine.context;

/**
 * Context exception
 */
public class ContextException extends Exception {
    /**
     * @param cause cause of exception
     */
    public ContextException(final Throwable cause) {
        super(cause);
    }
}
