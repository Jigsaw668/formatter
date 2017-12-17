package it.sevenbits.app.stateMachine.command;

/**
 *
 */
public class CommandException extends Exception {
    /**
     * Constructor with exception cause
     * @param cause cause of exception
     */
    public CommandException(final Throwable cause) {
        super(cause);
    }
}
