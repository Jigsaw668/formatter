package it.sevenbits.app.stateMachine.commands;

public class CommandException extends Exception {

    /**
     * Empty constructor
     */
    public CommandException() {
        super();
    }

    /**
     * Constructor with message
     * @param message error message
     */
    public CommandException(final String message) {
        super(message);
    }

    /**
     * Constructor with exception cause
     * @param cause cause of exception
     */
    public CommandException(final Throwable cause) {
        super(cause);
    }

    /**
     * Constructor with message and exception cause
     * @param message error message
     * @param cause cause of exception
     */
    public CommandException(final String message, final Throwable cause) {
        super(message, cause);
    }
}
