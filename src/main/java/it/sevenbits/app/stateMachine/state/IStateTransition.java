package it.sevenbits.app.stateMachine.state;

import it.sevenbits.app.stateMachine.token.IToken;

/**
 * interfaces for StateTransition
 */
public interface IStateTransition {
    /**
     * Next state for tokens, used in formatter
     * @param state state
     * @param token token
     * @return next state
     */
    IState nextState(IState state, IToken token);
}
