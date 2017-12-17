package it.sevenbits.app.stateMachine.state.formatterState;

import it.sevenbits.app.stateMachine.state.IState;
import it.sevenbits.app.stateMachine.Pair;
import it.sevenbits.app.stateMachine.state.State;
import it.sevenbits.app.stateMachine.state.formatterState.IStateTransition;
import it.sevenbits.app.lexer.token.IToken;

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
        transitions.put(new Pair<>(new State("default"), "singlecomment"), new State("singlecomment"));
        transitions.put(new Pair<>(new State("default"), "multicommentbegin"), new State("multicomment"));
        transitions.put(new Pair<>(new State("default"), "doublequote"), new State("stringliteral"));

        transitions.put(new Pair<>(new State("stringliteral"), "doublequote"), new State("default"));
        transitions.put(new Pair<>(new State("stringliteral"), null), new State("stringliteral"));

        transitions.put(new Pair<>(new State("singlecomment"), "newline"), new State("linestart"));
        transitions.put(new Pair<>(new State("singlecomment"), null), new State("singlecomment"));

        transitions.put(new Pair<>(new State("multicomment"), "multicommentend"), new State("linestart"));
        transitions.put(new Pair<>(new State("multicomment"), null), new State("multicomment"));

        transitions.put(new Pair<>(new State("linestart"), "newline"), new State("linestart"));
        transitions.put(new Pair<>(new State("linestart"), "space"), new State("linestart"));
        transitions.put(new Pair<>(new State("linestart"), "char"), new State("default"));
        transitions.put(new Pair<>(new State("linestart"), "closebracket"), new State("linestart"));
        transitions.put(new Pair<>(new State("linestart"), "doublequote"), new State("default"));
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