package it.sevenbits.app.stateMachine.state.lexerState;

import it.sevenbits.app.stateMachine.state.IState;
import it.sevenbits.app.stateMachine.Pair;
import it.sevenbits.app.stateMachine.state.State;

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
        states.put(new Pair<>(new State("default"), '/'), new State("slash"));
        states.put(new Pair<>(new State("default"), '*'), new State("asterisk"));
        states.put(new Pair<>(new State("slash"), '/'), new State("singlecomment"));
        states.put(new Pair<>(new State("slash"), '*'), new State("multicommentbegin"));
        states.put(new Pair<>(new State("asterisk"), '/'), new State("multicommentend"));
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