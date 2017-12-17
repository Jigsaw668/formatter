package it.sevenbits.app.stateMachine.state.lexerState;

import it.sevenbits.app.stateMachine.state.IState;

/**
 * Interface for state transition
 */
public interface IStateTransition {

    /**
     * @param state state
     * @param ch char
     * @return next state
     */
    IState getNextState(IState state, char ch);
}