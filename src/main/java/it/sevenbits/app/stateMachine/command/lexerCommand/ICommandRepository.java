package it.sevenbits.app.stateMachine.command.lexerCommand;

import it.sevenbits.app.stateMachine.state.IState;

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
