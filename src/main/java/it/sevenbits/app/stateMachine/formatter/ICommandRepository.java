package it.sevenbits.app.stateMachine.formatter;

import it.sevenbits.app.stateMachine.IState;
import it.sevenbits.app.stateMachine.token.IToken;

/**
 * interface for command repository
 */
public interface ICommandRepository {
    /**
     * Returns command for formatter
     * @param state state
     * @param token token
     * @return command
     */
    ICommand getCommand(IState state, IToken token);
}
