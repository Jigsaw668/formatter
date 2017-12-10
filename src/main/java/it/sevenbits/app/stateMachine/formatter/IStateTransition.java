package it.sevenbits.app.stateMachine.formatter;

import it.sevenbits.app.stateMachine.IState;
import it.sevenbits.app.stateMachine.token.IToken;

/**
 * Interface for state transition
 */
public interface IStateTransition {

    /**
     * @param state state
     * @param token token
     * @return next state
     */
    IState getNextState(IState state, IToken token);
}
