package it.sevenbits.app.stateMachine.lexer.implementation;

import it.sevenbits.app.stateMachine.IState;
import it.sevenbits.app.stateMachine.Pair;

import it.sevenbits.app.stateMachine.State;
import it.sevenbits.app.stateMachine.lexer.ICommand;
import it.sevenbits.app.stateMachine.lexer.ICommandRepository;

import java.util.HashMap;
import java.util.Map;

/**
 * Command repo
 */
public class CommandRepository implements ICommandRepository {

    private final Map<Pair<IState, Character>, ICommand> commands = new HashMap<>();

    /**
     * Basic constructor
     */
    CommandRepository() {
        commands.put(new Pair<>(new State("default"), null),
                (ch, context) -> {
                    context.appendLexeme(ch); context.setTokenName("char"); });
        commands.put(new Pair<>(new State("default"), ';'),
                (ch, context) -> {
                    context.appendLexeme(ch); context.setTokenName("semicolon"); });

        commands.put(new Pair<>(new State("default"), '{'),
                (ch, context) -> {
                    context.appendLexeme(ch); context.setTokenName("openbracket"); });
        commands.put(new Pair<>(new State("default"), '}'),
                (ch, context) -> {
                    context.appendLexeme(ch); context.setTokenName("closebracket"); });

        commands.put(new Pair<>(new State("default"), '\n'),
                (ch, context) -> {
                    context.appendLexeme(ch); context.setTokenName("newline"); });
        commands.put(new Pair<>(new State("default"), ' '),
                (ch, context) -> {
                    context.appendLexeme(ch); context.setTokenName("space"); });

        commands.put(new Pair<>(new State("spacing"), ' '),
                (ch, context) -> {
                    context.appendLexeme(ch); context.setTokenName("space"); });
        commands.put(new Pair<>(new State("spacing"), null),
                (ch, context) -> {
                    context.appendPostpone(ch); });
        commands.put(new Pair<>(new State("spacing"), '{'),
                (ch, context) -> {
                    context.appendPostpone(ch); });
        commands.put(new Pair<>(new State("spacing"), '}'),
                (ch, context) -> {
                    context.appendPostpone(ch); });
    }

    @Override
    public ICommand getCommand(final IState state, final char ch) {
        ICommand command = commands.get(new Pair<>(state, ch));
        if (command == null) {
            command = commands.get(new Pair<>(state, (Character) null));
        }
        return command;
    }
}
