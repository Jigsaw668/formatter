package it.sevenbits.app.stateMachine.lexer;

import it.sevenbits.app.stateMachine.IState;

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