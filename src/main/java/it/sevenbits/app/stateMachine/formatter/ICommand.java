package it.sevenbits.app.stateMachine.formatter;

import it.sevenbits.app.stateMachine.CommandException;
import it.sevenbits.app.stateMachine.token.IToken;

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
