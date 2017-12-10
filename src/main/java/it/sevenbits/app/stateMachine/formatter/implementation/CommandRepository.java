package it.sevenbits.app.stateMachine.formatter.implementation;

import it.sevenbits.app.stateMachine.IState;
import it.sevenbits.app.stateMachine.Pair;
import it.sevenbits.app.stateMachine.State;
import it.sevenbits.app.stateMachine.formatter.ICommand;
import it.sevenbits.app.stateMachine.formatter.ICommandRepository;
import it.sevenbits.app.stateMachine.formatter.implementation.commands.*;
import it.sevenbits.app.stateMachine.token.IToken;

import java.util.HashMap;

/**
 * Implementation of command repository for formatter
 */
public class CommandRepository implements ICommandRepository {

    private HashMap<Pair<IState, String>, ICommand> commands = new HashMap<>();

    /**
     * Basic constructor
     */
    CommandRepository() {
        commands.put(new Pair<>(new State("default"), "char"), new DefaultCommand());
        commands.put(new Pair<>(new State("default"), "space"), new DefaultCommand());
        commands.put(new Pair<>(new State("default"), "semicolon"), new SemicolonCommand());
        commands.put(new Pair<>(new State("default"), "openbracket"), new OpenBracketCommand());

        commands.put(new Pair<>(new State("linestart"), "newline"), new NewLineCommand());
        commands.put(new Pair<>(new State("linestart"), "space"), new NewLineCommand());
        commands.put(new Pair<>(new State("linestart"), "char"), new DefaultNewLineCommand());
        commands.put(new Pair<>(new State("linestart"), "closebracket"), new CloseBracketCommand());
    }

    @Override
    public ICommand getCommand(final IState state, final IToken token) {
        ICommand command = commands.get(new Pair<>(state, token.getName()));
        if (command == null) {
            command = commands.get(new Pair<>(state, (String) null));
        }
        return command;
    }
}
