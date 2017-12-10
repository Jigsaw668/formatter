package it.sevenbits.app.stateMachine.formatter.implementation;

import it.sevenbits.app.stateMachine.IState;
import it.sevenbits.app.stateMachine.Pair;
import it.sevenbits.app.stateMachine.State;
import it.sevenbits.app.stateMachine.formatter.IStateTransition;
import it.sevenbits.app.stateMachine.token.IToken;

import java.util.HashMap;
import java.util.Map;

/**
 * Implementation of state transition for formatter
 */
public class StateTransitions implements IStateTransition {

    private final Map<Pair<IState, String>, IState> transitions = new HashMap<>();

    /**
     * Basic constructor
     */
    StateTransitions() {
        transitions.put(new Pair<>(new State("default"), "char"), new State("default"));
        transitions.put(new Pair<>(new State("default"), "space"), new State("default"));
        transitions.put(new Pair<>(new State("default"), "semicolon"), new State("linestart"));
        transitions.put(new Pair<>(new State("default"), "openbracket"), new State("linestart"));

        transitions.put(new Pair<>(new State("linestart"), "newline"), new State("linestart"));
        transitions.put(new Pair<>(new State("linestart"), "space"), new State("linestart"));
        transitions.put(new Pair<>(new State("linestart"), "char"), new State("default"));
        transitions.put(new Pair<>(new State("linestart"), "closebracket"), new State("linestart"));
    }

    @Override
    public IState getNextState(final IState state, final IToken token) {
        IState nextState = transitions.get(new Pair<>(state, token.getName()));
        if (nextState == null) {
            nextState = transitions.get(new Pair<>(state, (String) null));
        }
        return nextState;
    }
}