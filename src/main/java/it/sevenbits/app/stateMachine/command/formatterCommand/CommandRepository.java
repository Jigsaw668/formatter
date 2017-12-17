package it.sevenbits.app.stateMachine.command.formatterCommand;

import it.sevenbits.app.stateMachine.state.IState;
import it.sevenbits.app.stateMachine.Pair;
import it.sevenbits.app.stateMachine.state.State;
import it.sevenbits.app.stateMachine.command.formatterCommand.commands.*;
import it.sevenbits.app.lexer.token.IToken;

import java.util.HashMap;

/**
 * Implementation of command repository for formatter
 */
public class CommandRepository implements ICommandRepository {

    private HashMap<Pair<IState, String>, ICommand> commands = new HashMap<>();

    /**
     * Basic constructor
     */
    public CommandRepository() {
        commands.put(new Pair<>(new State("default"), "char"), new DefaultCommand());
        commands.put(new Pair<>(new State("default"), "space"), new DefaultCommand());
        commands.put(new Pair<>(new State("default"), "semicolon"), new SemicolonCommand());
        commands.put(new Pair<>(new State("default"), "openbracket"), new OpenBracketCommand());
        commands.put(new Pair<>(new State("default"), "doublequote"), new DefaultCommand());
        commands.put(new Pair<>(new State("default"), "singlecomment"), new DefaultCommand());
        commands.put(new Pair<>(new State("default"), "multicommentbegin"), new DefaultCommand());

        commands.put(new Pair<>(new State("stringliteral"), "doublequote"), new DefaultCommand());
        commands.put(new Pair<>(new State("stringliteral"), null), new DefaultCommand());

        commands.put(new Pair<>(new State("singlecomment"), null), new DefaultCommand());
        commands.put(new Pair<>(new State("singlecomment"), "newline"), new DefaultNewLineCommand());

        commands.put(new Pair<>(new State("multicomment"), null), new DefaultCommand());
        commands.put(new Pair<>(new State("multicomment"), "multicommentend"), new MultiLineCommendEndCommand());

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
