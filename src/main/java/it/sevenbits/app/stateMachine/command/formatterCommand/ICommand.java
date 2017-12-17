package it.sevenbits.app.stateMachine.command.formatterCommand;

import it.sevenbits.app.stateMachine.command.CommandException;
import it.sevenbits.app.lexer.token.IToken;
import it.sevenbits.app.stateMachine.context.formatterContext.IContext;

/**
 * command interface
 */
public interface ICommand {

    /**
     * @param context context
     * @param token token
     * @throws CommandException exception
     */
    void execute(IToken token, IContext context) throws CommandException;
}
