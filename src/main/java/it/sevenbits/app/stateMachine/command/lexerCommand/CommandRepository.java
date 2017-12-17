package it.sevenbits.app.stateMachine.command.lexerCommand;

import it.sevenbits.app.stateMachine.state.IState;
import it.sevenbits.app.stateMachine.Pair;

import it.sevenbits.app.stateMachine.state.State;

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
    public CommandRepository() {
        commands.put(new Pair<>(new State("default"), '\n'),
                (ch, context) -> {
            context.appendLexeme(ch); context.setTokenName("newline"); });
        commands.put(new Pair<>(new State("default"), ' '),
                (ch, context) -> {
                    context.appendLexeme(ch); context.setTokenName("space"); });

        commands.put(new Pair<>(new State("default"), null),
                (ch, context) -> {
                    context.appendLexeme(ch); context.setTokenName("char"); });
        commands.put(new Pair<>(new State("default"), '\"'),
                (ch, context) -> {
                    context.appendLexeme(ch); context.setTokenName("doublequote"); });
        commands.put(new Pair<>(new State("default"), ';'),
                (ch, context) -> {
                    context.appendLexeme(ch); context.setTokenName("semicolon"); });

        commands.put(new Pair<>(new State("default"), '{'),
                (ch, context) -> {
                    context.appendLexeme(ch); context.setTokenName("openbracket"); });
        commands.put(new Pair<>(new State("default"), '}'),
                (ch, context) -> {
                    context.appendLexeme(ch); context.setTokenName("closebracket"); });


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

        commands.put(new Pair<>(new State("default"), '/'),
                (ch, context) -> {
                    context.appendLexeme(ch); context.setTokenName("slash"); });
        commands.put(new Pair<>(new State("default"), '*'),
                (ch, context) -> {
                    context.appendLexeme(ch); context.setTokenName("asterisk"); });
        commands.put(new Pair<>(new State("slash"), '/'),
                (ch, context) -> {
                    context.appendLexeme(ch); context.setTokenName("singlecomment"); });
        commands.put(new Pair<>(new State("singlecomment"), null),
                (ch, context) -> {
                    context.appendPostpone(ch); });
        commands.put(new Pair<>(new State("slash"), '*'),
                (ch, context) -> {
                    context.appendLexeme(ch); context.setTokenName("multicommentbegin"); });
        commands.put(new Pair<>(new State("multicommentbegin"), null),
                (ch, context) -> {
                    context.appendPostpone(ch); });
        commands.put(new Pair<>(new State("asterisk"), '/'),
                (ch, context) -> {
                    context.appendLexeme(ch); context.setTokenName("multicommentend"); });
        commands.put(new Pair<>(new State("multicommentend"), null),
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
