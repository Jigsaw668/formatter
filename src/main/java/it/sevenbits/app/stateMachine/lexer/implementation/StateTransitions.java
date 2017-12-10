package it.sevenbits.app.stateMachine.lexer.implementation;

import it.sevenbits.app.stateMachine.IState;
import it.sevenbits.app.stateMachine.Pair;
import it.sevenbits.app.stateMachine.State;
import it.sevenbits.app.stateMachine.lexer.IStateTransition;

import java.util.HashMap;
import java.util.Map;

/**
 * Implementation for State transition
 */
public class StateTransitions implements IStateTransition {

    private final Map<Pair<IState, Character>, IState> states = new HashMap<>();

    /**
     * Basic constructor
     */
    StateTransitions() {
        states.put(new Pair<>(new State("default"), ' '), new State("spacing"));
        states.put(new Pair<>(new State("spacing"), ' '), new State("spacing"));
    }

    @Override
    public IState getNextState(final IState state, final char ch) {
        IState nextState = states.get(new Pair<>(state, ch));
        if (nextState == null) {
            nextState = states.get(new Pair<>(state, (Character) null));
        }
        return nextState;
    }
}