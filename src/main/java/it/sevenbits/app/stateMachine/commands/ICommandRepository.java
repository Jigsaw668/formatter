package it.sevenbits.app.stateMachine.commands;

import it.sevenbits.app.stateMachine.state.IState;
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
