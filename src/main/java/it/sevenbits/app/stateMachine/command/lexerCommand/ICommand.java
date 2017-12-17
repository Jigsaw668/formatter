package it.sevenbits.app.stateMachine.command.lexerCommand;

import it.sevenbits.app.stateMachine.context.lexerContext.IContext;

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
