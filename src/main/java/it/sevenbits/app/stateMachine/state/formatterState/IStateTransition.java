package it.sevenbits.app.stateMachine.state.formatterState;

import it.sevenbits.app.stateMachine.state.IState;
import it.sevenbits.app.lexer.token.IToken;

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
