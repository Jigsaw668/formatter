package it.sevenbits.app.stateMachine.lexer;

import it.sevenbits.app.stateMachine.IState;

/**
 * Interface for command repository
 */
public interface ICommandRepository {

    /**
     * @param state state
     * @param ch character
     * @return command
     */
    ICommand getCommand(IState state, char ch);
}
