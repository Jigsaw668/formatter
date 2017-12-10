package it.sevenbits.app.stateMachine.lexer;

/**
 * Interface for command
 */
public interface ICommand {

    /**
     * @param ch char
     * @param context context
     */
    void execute(char ch, IContext context);
}
